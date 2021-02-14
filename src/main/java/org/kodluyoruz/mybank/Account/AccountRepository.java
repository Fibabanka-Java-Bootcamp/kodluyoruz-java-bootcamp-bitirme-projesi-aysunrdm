package org.kodluyoruz.mybank.Account;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository {

        public AccountEntity addAccount(AccountEntity accountEntity);
        public AccountEntity updateAccount(AccountEntity accountEntity);
        public void deleteAccount(Long accountId);
        public AccountEntity getAccount(Long accountId);
        public List<AccountEntity> getAccounts();

    }
