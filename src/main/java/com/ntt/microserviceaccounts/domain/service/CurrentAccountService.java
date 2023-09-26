package com.ntt.microserviceaccounts.domain.service;

import com.ntt.microserviceaccounts.domain.model.enity.CurrentAccount;

import java.util.List;

public interface CurrentAccountService {
    List<CurrentAccount> getAll();
    String save(CurrentAccount account, String documentNumber);
}
