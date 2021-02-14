package org.kodluyoruz.mybank.Account;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/account")
public class AccountController {


        Logger LOG = Logger.getLogger(AccountController.class.getName());

        @Autowired(required=true)
        @Qualifier("accountService")
        private AccountService accountService;

        @GetMapping("/{accountId}")
        public AccountEntity getAccounts(@PathVariable("accountId") Long accountId){

            return accountService.getAccount(accountId);
        }

        @RequestMapping(value="/all",method= RequestMethod.GET)
        public List<AccountEntity> allAccounts(){
            List<AccountEntity> list = accountService.getAllAccounts();
            return list;
        }
        //
        @RequestMapping(value="/update",method=RequestMethod.POST)
        public AccountEntity editAccount(@RequestBody AccountEntity account){
            account = accountService.updateAccount(account);
            return account;

        }
        //
        @RequestMapping(value="/add",method=RequestMethod.POST)
        public AccountEntity addAccount(@RequestBody AccountEntity account){
            account = accountService.addAccount(account);
            return account;
        }

    }