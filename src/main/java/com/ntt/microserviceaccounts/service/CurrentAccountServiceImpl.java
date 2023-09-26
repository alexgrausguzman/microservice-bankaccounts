package com.ntt.microserviceaccounts.service;

import com.ntt.microserviceaccounts.domain.model.enity.CurrentAccount;
import com.ntt.microserviceaccounts.domain.repository.CurrentAccountRepository;

import com.ntt.microserviceaccounts.domain.service.BusinessRuleService;
import com.ntt.microserviceaccounts.domain.service.CurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public String save(CurrentAccount currentAccount, String documentNumber) {

        if (!businessRuleService.validateCurrentAccount(documentNumber)){
            return "El cliente no cumple los requisitos";
        }
        currentAccount.setDocumentNumber(documentNumber);
        currentAccountRepository.save(currentAccount);
       return "Registro éxitoso";
    }


}
