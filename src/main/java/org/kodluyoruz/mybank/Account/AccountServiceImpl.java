package org.kodluyoruz.mybank.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Transactional
    public AccountEntity createAccount(AccountDTO account) {

        System.out.println("Account Service Create invoked...");

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setAccountType(account.getAccountType());
        accountEntity.setAccountNo(account.getAccountNo());
        accountEntity.setCustomerId(account.getCustomerId());
        accountEntity.setBankCode(account.getBankCode());
        accountEntity.setCurrency(account.getCurrency());
        accountEntity.setBalance(account.getBalance());

        return accountRepository.save(accountEntity);
    }


    @Transactional
    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }


    @Transactional
    public AccountEntity updateAccount(Long accountId, AccountDTO request) {

        AccountEntity updatedAccount = Optional.ofNullable(accountRepository.findOne(accountId)).map(accountEntity -> {

            AccountEntity account = new AccountEntity();

            account.setAccountId(request.getAccountId());
            account.setAccountType(request.getAccountType());
            account.setAccountNo(request.getAccountNo());
            account.setCustomerId(request.getCustomerId());
            account.setBankCode(request.getBankCode());
            account.setCurrency(request.getCurrency());
            account.setBalance(request.getBalance());
            return account;

        }).get();

        return accountRepository.save(updatedAccount);
    }

    @Transactional
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }


    @Transactional
    public boolean savingAccount(Long accountId) {

        return this.accountRepository.findById(accountId).get().getAccountType().equals(AccountType.SAVING_ACCOUNT);

    }


}