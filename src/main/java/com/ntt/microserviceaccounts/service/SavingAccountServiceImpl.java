package com.ntt.microserviceaccounts.service;

import com.ntt.microserviceaccounts.domain.model.enity.CurrentAccount;
import com.ntt.microserviceaccounts.domain.model.enity.SavingAccount;
import com.ntt.microserviceaccounts.domain.repository.SavingAccountRepository;
import com.ntt.microserviceaccounts.domain.service.BankAccountService;
import com.ntt.microserviceaccounts.domain.service.BusinessRuleService;
import com.ntt.microserviceaccounts.domain.service.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SavingAccountServiceImpl implements SavingAccountService {


    @Autowired
    private BusinessRuleService businessRuleService;
    @Autowired
    private SavingAccountRepository savingAccountRepository;

    @Override
    public List<SavingAccount> getAll() {
        return savingAccountRepository.findAll();
    }


    @Override
    public String save(SavingAccount savingAccount, String documentNumber) {

        if (!businessRuleService.validateSavingsAndFixedAccount(documentNumber)){
            return "El cliente no cumple los requisitos";
        }
        savingAccount.setDocumentNumber(documentNumber);
        savingAccountRepository.save(savingAccount);
        return "Registro éxitoso";
    }

}
