package com.ntt.microserviceaccounts.service;

import com.ntt.microserviceaccounts.domain.model.enity.BankAccount;
import com.ntt.microserviceaccounts.domain.model.enity.Customer;
import com.ntt.microserviceaccounts.domain.repository.BankAccountRepository;
import com.ntt.microserviceaccounts.domain.service.BusinessRuleService;
import com.ntt.microserviceaccounts.external.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessRuleServiceImpl implements BusinessRuleService {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Override
    public boolean validateSavingsAndFixedAccount(String documentNumber) {
        Customer customer = customerService.getByDocumentNumber(documentNumber);
        if(customer != null){
            List<BankAccount> bankAccounts = bankAccountRepository.findByDocumentNumber(documentNumber);
            if (customer.getTypeCustomer().equals("personal")) return bankAccounts.isEmpty();
        }
        return false;
    }
    @Override
    public boolean validateCurrentAccount(String documentNumber) {
        Customer customer = customerService.getByDocumentNumber(documentNumber);
        if(customer != null){
            List<BankAccount> bankAccounts = bankAccountRepository.findByDocumentNumber(documentNumber);
            if (customer.getTypeCustomer().equals("personal")) return bankAccounts.isEmpty();
            return customer.getTypeCustomer().equals("empresarial");
        }
        return false;
    }

}
