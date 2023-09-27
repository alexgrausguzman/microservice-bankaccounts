package com.ntt.microserviceaccounts.service;

import com.ntt.microserviceaccounts.domain.model.enity.BankAccount;
import com.ntt.microserviceaccounts.domain.model.enity.Customer;
import com.ntt.microserviceaccounts.domain.model.enity.FixedTermAccount;
import com.ntt.microserviceaccounts.domain.model.enity.SavingAccount;
import com.ntt.microserviceaccounts.domain.repository.BankAccountRepository;
import com.ntt.microserviceaccounts.domain.service.BankAccountService;
import com.ntt.microserviceaccounts.exception.BankAccountNotFoundException;
import com.ntt.microserviceaccounts.external.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private CustomerService customerService;


    @Override
    public List<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount save(BankAccount bankAccount, String documentNumber) {
        bankAccount.setDocumentNumber(documentNumber);
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public List<BankAccount> getAllAccountsCustomer(String documentNumber) {
        return bankAccountRepository.findByDocumentNumber(documentNumber);
    }


    @Override
    public BankAccount getBankAccount(String accountNumber) {
        if (!bankAccountRepository.existsByAccountNumber(accountNumber)){
            throw new BankAccountNotFoundException(accountNumber);
        }
        return bankAccountRepository.findByAccountNumber(accountNumber);
    }
    @Override
    public boolean validateAccount(String accountNumber) {
        return bankAccountRepository.existsByAccountNumber(accountNumber);
    }




}
