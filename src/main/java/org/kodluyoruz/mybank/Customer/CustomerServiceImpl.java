package org.kodluyoruz.mybank.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.lang.*;


@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public CustomerEntity addCustomer(CustomerEntity customer) {

        System.out.println("Customer Service create invoked:"+ customer.getCustomerName());
        customer = customerRepository.addCustomer(customer);
        return customer;


    }

    @Transactional
    public CustomerEntity updateCustomer(CustomerEntity customer) {

        System.out.println("Customer Service Update invoked:" + customer.getCustomerName());
        customer = customerRepository.updateCustomer(customer);
        return customer;
    }

    public CustomerEntity getCustomer(Long customerId) {
        return customerRepository.getCustomer(customerId);
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.getCustomers();
    }

    @Transactional
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteCustomer(customerId);
    }
}


/*
    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        customer= customerRepository.saveCustomer(customer);
        return customer;
    }
*/