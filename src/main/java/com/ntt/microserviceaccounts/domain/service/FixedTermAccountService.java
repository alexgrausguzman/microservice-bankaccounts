package com.ntt.microserviceaccounts.domain.service;

import com.ntt.microserviceaccounts.domain.model.enity.CurrentAccount;
import com.ntt.microserviceaccounts.domain.model.enity.FixedTermAccount;

import java.util.List;

public interface FixedTermAccountService {
    List<FixedTermAccount> getAll();
    String save(FixedTermAccount fixedTermAccount, String documentNumber);
}
