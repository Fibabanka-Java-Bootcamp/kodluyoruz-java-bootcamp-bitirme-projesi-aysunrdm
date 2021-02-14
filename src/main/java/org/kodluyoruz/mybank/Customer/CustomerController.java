package org.kodluyoruz.mybank.Customer;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.lang.*;


@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired()
    @Qualifier("customerService")
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public CustomerEntity getCustomers(@PathVariable("customerId") Long customerId) {

        return customerService.getCustomer(customerId);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CustomerEntity> allCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CustomerEntity editCustomer(@RequestBody CustomerEntity customer) {
        customer = customerService.updateCustomer(customer);
        return customer;

    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public CustomerEntity saveCustomerEntity(@RequestBody CustomerEntity customerEntity) {
      System.out.println("CustomerEntity save has been started.. ");
        return customerService.addCustomer(customerEntity);
    }



/*
    @PostMapping("/add")
    CustomerEntity newEmployee(@RequestBody CustomerEntity customerEntity) {
        return custom.save(customerEntity);
    }
*/


}




     /*



    @RequestMapping(value="/save",method=RequestMethod.POST)
    public CustomerEntity saveCustomer(@RequestBody CustomerEntity customer){
        // CustomerEntity c= new CustomerEntity();
        customer = customerService.saveCustomer(customer);
        return customer;
    }




         /* @RequestMapping(value="/add",method=RequestMethod.POST)
        public CustomerEntity addCustomer(CustomerEntity customer){
           // CustomerEntity c= new CustomerEntity();

            return customerService.addCustomer(customer);
        }*/