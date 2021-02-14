package org.kodluyoruz.mybank.Account;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository("accountRepository")
@Transactional
public class AccountRepositoryImpl implements AccountRepository {


    @PersistenceContext
    public EntityManager entityManager;

    @Transactional(readOnly = false)
    public AccountEntity addAccount(AccountEntity accountEntity) {

        entityManager.persist(accountEntity);
        return accountEntity;
    }

    @Transactional(readOnly = false)
    public AccountEntity updateAccount(AccountEntity accountEntity) {
        entityManager.merge(accountEntity);
        return accountEntity;
    }


    @Transactional(readOnly = false)
    public void deleteAccount(Long accountId) {

        AccountEntity accountEntity = getAccount(accountId);
        entityManager.remove(accountEntity);
    }

    @Transactional(readOnly = true)
    public AccountEntity getAccount(Long accountId) {
        String sql = "select account from AccountEntity account where account.accountId=" + accountId;
        try {
            return (AccountEntity) entityManager.createQuery(sql).getSingleResult();
        } catch (Exception e) {
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List getAccounts() {

        return entityManager.createQuery("select account from AccountEntity account").getResultList();
    }

}
