package org.kodluyoruz.mybank.Customer;
import java.util.List;
import java.lang.*;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

     CustomerEntity addCustomer(CustomerEntity customer);
     CustomerEntity updateCustomer(CustomerEntity customer);
     CustomerEntity getCustomer(Long customerId);
     List<CustomerEntity> getAllCustomers();
     void deleteCustomer(Long customerId);

    //CustomerEntity save(CustomerEntity customerEntity);
}
