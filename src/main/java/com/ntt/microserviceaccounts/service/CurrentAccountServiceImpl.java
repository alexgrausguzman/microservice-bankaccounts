package com.ntt.microserviceaccounts.service;

import com.ntt.microserviceaccounts.domain.model.enity.CurrentAccount;
import com.ntt.microserviceaccounts.domain.model.enity.Customer;
import com.ntt.microserviceaccounts.domain.repository.CurrentAccountRepository;

import com.ntt.microserviceaccounts.domain.service.BusinessRuleService;
import com.ntt.microserviceaccounts.domain.service.CurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurrentAccountServiceImpl implements CurrentAccountService {


    @Autowired
    private BusinessRuleService businessRuleService;

    @Autowired
    private CurrentAccountRepository currentAccountRepository;




    @Override
    public List<CurrentAccount> getAll() {
        return currentAccountRepository.findAll();
    }

    @Override
    public Map<String, Object> save(CurrentAccount currentAccount, String documentNumber) {
        Map<String, Object>  resp = new HashMap<>();

        if (!businessRuleService.validateCurrentAccount(documentNumber)){
            resp.put("succes", false);
            resp.put("message", "The business rule is not followed");
        }else {
            currentAccount.setDocumentNumber(documentNumber);
            currentAccount.setTypeAccount("current");
            currentAccount.setAccountHolderIds(new ArrayList<>());
            currentAccount.setAuthorizedSignatoryIds(new ArrayList<>());
            currentAccountRepository.save(currentAccount);
            resp.put("succes", true);
            resp.put("message", "Checking account registered correctly");
        }

       return resp;
    }

    @Override
    public String updateCurrentCustomer(CurrentAccount account, String documentNumber) {


        return "";
    }


}
