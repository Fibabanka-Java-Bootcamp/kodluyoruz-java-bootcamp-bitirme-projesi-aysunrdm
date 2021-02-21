package org.kodluyoruz.mybank.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.lang.*;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    default <S extends CustomerEntity> Optional<S> findOne(Long example) {
        return Optional.empty();
    }

    void deleteById(Long customerId);


}


