package org.kodluyoruz.mybank.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    default <S extends AccountEntity> Optional<S> findOne(Long example) {
        return Optional.empty();
    }

    void deleteById(Long accountId);


}
