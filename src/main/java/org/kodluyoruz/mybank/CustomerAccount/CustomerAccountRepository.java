package org.kodluyoruz.mybank.CustomerAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccountCard, Long> {

    CustomerAccountCard findCustomerAccountByCustomerId(Long customerId);
}
