package org.kodluyoruz.mybank.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {


        @Autowired(required=true)
        @Qualifier("accountRepository")
        private AccountRepository accountRepository;

        @Transactional
        public AccountEntity addAccount(AccountEntity account) {

            System.out.println("Account Service create invoked:" + account.getAccountNo());
            account = accountRepository.addAccount(account);
            return account;
        }
        @Transactional
        public AccountEntity updateAccount(AccountEntity account) {

            System.out.println("Account Service Update invoked:" + account.getAccountNo());
            account = accountRepository.updateAccount(account);
            return account;
        }

        public AccountEntity getAccount(Long accountId) {
            return accountRepository.getAccount(accountId);
        }

        public List<AccountEntity> getAllAccounts() {
            return (List<AccountEntity>) accountRepository.getAccounts();
        }

        @Transactional
        public void deleteAccount(Long accountId) {
            accountRepository.deleteAccount(accountId);
        }

    }