package com.ntt.microserviceaccounts.service;


import com.ntt.microserviceaccounts.domain.model.enity.FixedTermAccount;
import com.ntt.microserviceaccounts.domain.repository.FixedTermAccountRepository;
import com.ntt.microserviceaccounts.domain.service.BankAccountService;
import com.ntt.microserviceaccounts.domain.service.BusinessRuleService;
import com.ntt.microserviceaccounts.domain.service.FixedTermAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedTermAccountServiceImpl implements FixedTermAccountService {

    @Autowired
    private BusinessRuleService businessRuleService;
    @Autowired
    private FixedTermAccountRepository fixedTermAccountRepository;

    @Override
    public List<FixedTermAccount> getAll() {
        return fixedTermAccountRepository.findAll();
    }

    @Override
    public String save(FixedTermAccount fixedTermAccount, String documentNumber) {
        if (!businessRuleService.validateSavingsAndFixedAccount(documentNumber)){
            return "El cliente no cumple los requisitos";
        }
        fixedTermAccount.setDocumentNumber(documentNumber);
        fixedTermAccountRepository.save(fixedTermAccount);
        return "Registro éxitoso";
    }

}
