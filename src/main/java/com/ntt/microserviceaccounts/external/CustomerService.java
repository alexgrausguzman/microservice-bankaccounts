package com.ntt.microserviceaccounts.external;


import com.ntt.microserviceaccounts.domain.model.enity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "customer-api", url = "http://localhost:8090/api/v1/customers")
public interface CustomerService {

    @GetMapping
    List<Customer> getAll();
    @GetMapping("{documentNumber}")
    Customer getByDocumentNumber(@PathVariable String documentNumber);

    @DeleteMapping("{id}")
    void deleteCustomer(@PathVariable Long id);

    @PatchMapping("{id}")
    ResponseEntity<Customer> patchUpdateCustomer(
            @PathVariable Long id,
            @RequestBody Customer updatedCustomer
    );

}
