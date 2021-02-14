package org.kodluyoruz.mybank.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.lang.*;

@Repository
public interface CustomerRepository  {

       CustomerEntity addCustomer(CustomerEntity customerEntity);
        CustomerEntity updateCustomer(CustomerEntity customerEntity);
        void deleteCustomer(Long customerId);
        CustomerEntity getCustomer(Long customerId);
        List<CustomerEntity> getCustomers();


        //CustomerEntity saveCustomer(CustomerEntity customer);

    }


