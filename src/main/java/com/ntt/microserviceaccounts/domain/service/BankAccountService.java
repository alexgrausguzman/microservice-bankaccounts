package com.ntt.microserviceaccounts.domain.service;

import com.ntt.microserviceaccounts.domain.model.enity.BankAccount;
import com.ntt.microserviceaccounts.domain.model.enity.Customer;

import java.util.List;

public interface BankAccountService {

    List<BankAccount> getAll();
    BankAccount save(BankAccount bankAccount,String documentNumber);

    List<BankAccount> getAllAccountsCustomer(String documentNumber);

    BankAccount getBankAccount(String accountNumber);
    boolean validateAccount(String accountNumber);


}
