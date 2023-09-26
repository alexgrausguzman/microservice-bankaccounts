package com.ntt.microserviceaccounts.domain.service;


import com.ntt.microserviceaccounts.domain.model.enity.CurrentAccount;
import com.ntt.microserviceaccounts.domain.model.enity.SavingAccount;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SavingAccountService {

    List<SavingAccount> getAll();

    String save(SavingAccount account, String documentNumber);
}
