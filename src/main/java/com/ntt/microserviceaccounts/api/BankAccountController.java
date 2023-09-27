package com.ntt.microserviceaccounts.api;

import com.ntt.microserviceaccounts.domain.model.enity.BankAccount;
import com.ntt.microserviceaccounts.domain.model.enity.Customer;
import com.ntt.microserviceaccounts.domain.service.BankAccountService;
import com.ntt.microserviceaccounts.external.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bankaccounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    /**
     * This method fetches a list of bank accounts from the database
     * and returns them as a response entity with a status code of 200 (OK)
     * if the operation is successful.
     * @return A response entity containing a list of bank accounts.
     */
    @GetMapping
    public ResponseEntity<List<BankAccount>> fetchAll(){
        return ResponseEntity.ok(bankAccountService.getAll());
    }

    /**
     * The method filters the accounts by user.
     *
     * @param documentNumber The customer document number.
     * @return A list of accounts.
     */
    @GetMapping("accounts")
    public ResponseEntity<List<BankAccount>> getAllAccounts(@RequestParam("document") String documentNumber){
        return ResponseEntity.ok(bankAccountService.getAllAccountsCustomer(documentNumber));
    }

    /**
     * This method fetches a bank account from the database based on the provided
     * account number and returns it.
     *
     * @param accountNumber The account number of the bank account to retrieve.
     * @return The bank account matching the provided account number or an HTTP 404 response if not found.
     */
    @GetMapping("accountnumber/{accountNumber}")
    public BankAccount getBankAccount(@PathVariable String accountNumber){
        return bankAccountService.getBankAccount(accountNumber);
    }



}
