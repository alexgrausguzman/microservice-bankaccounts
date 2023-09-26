package com.ntt.microserviceaccounts.api;


import com.ntt.microserviceaccounts.domain.model.enity.CurrentAccount;
import com.ntt.microserviceaccounts.domain.service.CurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/currentaccounts")
public class CurrentAccountController {

    @Autowired
    private CurrentAccountService currentAccountService;

    @GetMapping
    public List<CurrentAccount> fetchAll(){
        return currentAccountService.getAll();
    }

    @PostMapping("{documentNumber}")
    public String save(@RequestBody CurrentAccount currentAccount,@PathVariable String documentNumber){
        return currentAccountService.save(currentAccount,documentNumber);
    }
}
