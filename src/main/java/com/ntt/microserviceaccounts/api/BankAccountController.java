package com.ntt.microserviceaccounts.api;

import com.ntt.microserviceaccounts.domain.model.enity.BankAccount;
import com.ntt.microserviceaccounts.domain.model.enity.Customer;
import com.ntt.microserviceaccounts.domain.service.BankAccountService;
import com.ntt.microserviceaccounts.external.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bankaccounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<BankAccount> fetchAll(){
        return bankAccountService.getAll();
    }
    @GetMapping("customers")
    public List<Customer> getCustomers(){
        return customerService.getAll();
    }

    @GetMapping("{documentNumber}")
    public List<BankAccount> getAllAccounts(@PathVariable String documentNumber){
        return bankAccountService.getAllAccountsCustomer(documentNumber);
    }
    @GetMapping("accountnumber/{accountNumber}")
    public BankAccount getBankAccount(@PathVariable String accountNumber){
        return bankAccountService.getBankAccount(accountNumber);
    }

/*
    @PostMapping("{typeCustomer}/{documentNumber}")
    public String savePersonalAccount(@RequestBody BankAccount bankAccount,@PathVariable String documentNumber,@PathVariable String typeCustomer){
        if (bankAccountService.validateCustomerAccount(documentNumber, typeCustomer)){
            return bankAccountService.save(bankAccount, documentNumber).toString();
        }
        return "No Cumple con los requisitos";
    }
*/
    /*
    @PostMapping("empresarial/{documentNumber}")
    public String saveEmpresarialAccount(@RequestBody BankAccount bankAccount,@PathVariable String documentNumber){
        if (bankAccountService.validateCustomerAccount(documentNumber)){
            return bankAccountService.save(bankAccount, documentNumber).toString();
        }
        return "No Cumple con los requisitos";
    }
        */
}
