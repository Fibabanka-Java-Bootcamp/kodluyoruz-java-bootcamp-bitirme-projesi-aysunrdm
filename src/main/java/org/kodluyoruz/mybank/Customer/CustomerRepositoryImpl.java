package org.kodluyoruz.mybank.Customer;

import java.util.List;
import java.lang.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("customerRepository")
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional()
    public CustomerEntity addCustomer(CustomerEntity customerEntity) {

        entityManager.persist(customerEntity);
        return customerEntity;
    }


    @Transactional()
    public CustomerEntity updateCustomer(CustomerEntity customerEntity) {
        entityManager.merge(customerEntity);
        return customerEntity;
    }


    @Transactional()
    public void deleteCustomer(Long customerId) {

        CustomerEntity customerEntity = getCustomer(customerId);
        entityManager.remove(customerEntity);
    }

    @Transactional(readOnly=true)
    public CustomerEntity getCustomer(Long customerId) {
        String sql = "select customer from CustomerEntity customer where customer.customerId=" + customerId;
        try{
            return (CustomerEntity) entityManager.createQuery(sql).getSingleResult();
        }catch(Exception e){
        }
        return null;
    }

    @Transactional(readOnly=true)
    public List<CustomerEntity> getCustomers() {

        return entityManager.createQuery("select customer from CustomerEntity customer").getResultList();
    }


}


    /*
    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        entityManager.persist(customer);
        return null;
    }
*/