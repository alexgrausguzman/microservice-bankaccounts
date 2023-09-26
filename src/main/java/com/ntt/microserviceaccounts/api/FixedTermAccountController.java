package com.ntt.microserviceaccounts.api;


import com.ntt.microserviceaccounts.domain.model.enity.FixedTermAccount;
import com.ntt.microserviceaccounts.domain.model.enity.SavingAccount;
import com.ntt.microserviceaccounts.domain.service.FixedTermAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fixedtermaccounts")
public class FixedTermAccountController {

    @Autowired
    private FixedTermAccountService fixedTermAccountService;


    @GetMapping
    public List<FixedTermAccount> fetchAll(){
        return fixedTermAccountService.getAll();
    }

    @PostMapping("{documentNumber}")
    public String save(@RequestBody FixedTermAccount fixedTermAccount, @PathVariable String documentNumber){
        return fixedTermAccountService.save(fixedTermAccount,documentNumber);
    }

}
