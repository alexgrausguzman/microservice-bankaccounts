package com.ntt.microserviceaccounts.api;


import com.ntt.microserviceaccounts.domain.model.enity.CurrentAccount;
import com.ntt.microserviceaccounts.domain.model.enity.SavingAccount;
import com.ntt.microserviceaccounts.domain.service.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/savingaccounts")
public class SavingAccountController {

    @Autowired
    private SavingAccountService savingAccountService;


    @GetMapping
    public List<SavingAccount> fecthAll(){
        return savingAccountService.getAll();
    }


    @PostMapping("{documentNumber}")
    public String save(@RequestBody SavingAccount savingAccount,@PathVariable String documentNumber){
        return savingAccountService.save(savingAccount,documentNumber);
    }



}
