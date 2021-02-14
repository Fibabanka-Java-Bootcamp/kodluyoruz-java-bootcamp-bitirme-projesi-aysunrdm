package org.kodluyoruz.mybank.Account;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AccountService {

        public AccountEntity addAccount(AccountEntity account);
        public AccountEntity updateAccount(AccountEntity account);
        public AccountEntity getAccount(Long accountId);
        public List<AccountEntity> getAllAccounts();
        public void deleteAccount(Long accountId);

    }


