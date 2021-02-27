package org.kodluyoruz.mybank.Account;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    AccountEntity createAccount(AccountDTO account);

    AccountEntity updateAccount(Long accountId, AccountDTO request);

    void deleteAccount(Long accountId);

    List<AccountEntity> findAll();

}


