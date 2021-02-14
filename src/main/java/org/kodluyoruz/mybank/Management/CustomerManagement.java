
/*
package org.kodluyoruz.mybank.Management;

import org.kodluyoruz.mybank.Customer.CustomerDTO;
import org.kodluyoruz.mybank.Customer.CustomerEntity;
import org.kodluyoruz.mybank.Customer.CustomerRepository;

import java.util.Arrays;

public class CustomerManagement {

private CustomerDTO customer;
private CustomerRepository customerRepo;
private CustomerEntity customerEntity;

private CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setCustomerName(customerDTO.getCustomerName());
    customerEntity.setCustomerSurname(customerDTO.getCustomerSurname());
    return customerEntity;

}

public CustomerEntity createNewCustomer(CustomerDTO customer){

     this.customerEntity=toCustomerEntity(customer);

    return customerRepo.addCustomer(customerEntity);


    }


}


Müşteri yönetimi
Yaratılacak API'lar aracılığıyla; müşteri yaratma, güncelleme ve silme işlemleri mümkün
    olacaktır. Silme işlemi hesaplarında parası bulunan yada kredi kartı borcu bulunan
    müşteriler için mümkün olmayacak.
*/




/*

    public CustomerDTO getCustomer() {
        CustomerEntity customerEntity ;
        Arrays.asList(customer.getCustomerId()).parallelStream().filter(aLong -> {



        })
        return customer;
    }




-Silinicek kullanıcı id si parametre olarak gelicek
-bu id ye bağlı hesaplar sorgulanacak
-Eğer açık hesap varsa hesabında para var mı, hesabında para varsa eğer silinemez,
diğer durumda silinir






 */