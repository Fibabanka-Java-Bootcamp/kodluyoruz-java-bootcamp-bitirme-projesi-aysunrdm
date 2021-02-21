package org.kodluyoruz.mybank.Customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    CustomerEntity createCustomer(CustomerDTO customer);

    CustomerEntity updateCustomer(Long customerId, CustomerDTO request);

    void deleteCustomer(Long customerId);

    List<CustomerEntity> findAll();


}
