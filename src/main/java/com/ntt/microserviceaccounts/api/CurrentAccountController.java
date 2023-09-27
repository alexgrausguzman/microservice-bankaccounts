package com.ntt.microserviceaccounts.api;


import com.ntt.microserviceaccounts.domain.model.enity.CurrentAccount;
import com.ntt.microserviceaccounts.domain.service.CurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/currentaccounts")
public class CurrentAccountController {

    @Autowired
    private CurrentAccountService currentAccountService;

    @GetMapping
    public ResponseEntity<List<CurrentAccount>> fetchAll(){
        List<CurrentAccount> listCurrentAccounts = currentAccountService.getAll() ;

        if (!listCurrentAccounts.isEmpty()){
            return ResponseEntity.ok(listCurrentAccounts);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PostMapping("{documentNumber}")
    public ResponseEntity<Map<String, Object>> save(@RequestBody CurrentAccount currentAccount, @PathVariable String documentNumber){
        Map<String, Object> resp = currentAccountService.save(currentAccount, documentNumber);

        boolean succes = (boolean) resp.get("succes");

        if(succes){
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }
}
