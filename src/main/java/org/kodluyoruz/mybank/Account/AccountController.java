package org.kodluyoruz.mybank.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
@RequestMapping(value = "/account", produces = "application/json")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountEntity createAccount(@RequestBody AccountDTO request) {
        return accountService.createAccount(request);
    }

    @GetMapping(value = "/list")
    public List<AccountEntity> listAllAccounts() {
        return accountService.findAll();
    }

    @PutMapping(value = "/update/{accountId}")
    public AccountEntity updateAccount(@PathVariable Long accountId, @RequestBody AccountDTO request) {
        return accountService.updateAccount(accountId, request);
    }


    @DeleteMapping("/delete/{accountId}")
    private void deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.deleteAccount(accountId);
    }


}