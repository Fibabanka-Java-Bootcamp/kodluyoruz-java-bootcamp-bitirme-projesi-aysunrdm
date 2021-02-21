package org.kodluyoruz.mybank.Customer;

import org.kodluyoruz.mybank.Account.AccountRepository;
import org.kodluyoruz.mybank.Card.CardRepository;
import org.kodluyoruz.mybank.CustomerAccount.CustomerAccountCard;
import org.kodluyoruz.mybank.CustomerAccount.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public CustomerEntity createCustomer(CustomerDTO customer) {

        System.out.println("Customer Service Create invoked...");

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomerName(customer.getCustomerName());
        customerEntity.setCustomerSurname(customer.getCustomerSurname());
        customerEntity.setCustomerNo(customer.getCustomerNo());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhone(customer.getPhone());
        return customerRepository.save(customerEntity);
    }


    @Transactional
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }


    @Transactional
    public CustomerEntity updateCustomer(Long customerId, CustomerDTO request) {

        CustomerEntity updatedCustomer = Optional.ofNullable(customerRepository.findOne(customerId)).map(customerEntity -> {

            CustomerEntity customer = new CustomerEntity();

            customer.setCustomerId(request.getCustomerId());
            customer.setCustomerName(request.getCustomerName());
            customer.setCustomerSurname(request.getCustomerSurname());
            customer.setCustomerNo(request.getCustomerNo());
            customer.setEmail(request.getEmail());
            customer.setPhone(request.getPhone());
            return customer;

        }).get();

        return customerRepository.save(updatedCustomer);
    }

    @Transactional
    public void deleteCustomer(Long customerId) {

        //Silme işlemi hesaplarında parası bulunan yada kredi kartı borcu bulunan müşteriler için mümkün olmayacak.


        CustomerAccountCard customerAccountCard = this.customerAccountRepository.findCustomerAccountByCustomerId(customerId);


        if (accountRepository.findById(customerAccountCard.getAccountId()).isPresent()) {
            try {
                if (accountRepository.findById(customerAccountCard.getAccountId()).get().getBalance().equals("0")) {
                    customerRepository.deleteById(customerId);
                } else if (cardRepository.findById(customerAccountCard.getCardId()).get().getCreditCardDebt() == 0) {

                    customerRepository.deleteById(customerId);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}





/*

@Autowired(required=true)
@Qualifier(value="customerRepository")
 */
