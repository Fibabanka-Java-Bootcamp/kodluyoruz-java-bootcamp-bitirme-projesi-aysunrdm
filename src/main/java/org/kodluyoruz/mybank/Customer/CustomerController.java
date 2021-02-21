package org.kodluyoruz.mybank.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.*;
import java.util.List;


@RestController
@RequestMapping(value = "/customer", produces = "application/json")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerEntity createCustomer(@RequestBody CustomerDTO request) {
        return customerService.createCustomer(request);
    }

    @GetMapping(value = "/list")
    public List<CustomerEntity> listAllCustomers() {
        return customerService.findAll();
    }


    @PutMapping(value = "/update/{customerId}")
    public CustomerEntity updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO request) {
        return customerService.updateCustomer(customerId, request);
    }


    @DeleteMapping("/delete/{customerId}")
    private void deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
    }

}







     /*



    @ResponseStatus(code = HttpStatus.CREATED)
   @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
       public CustomerEntity addCustomerEntity(@RequestBody CustomerEntity customerEntity) {

      System.out.println("CustomerEntity add has been started... ");

        return customerService.save(customerEntity);
    }


    */