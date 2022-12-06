package com.beautyandhealth.repositoryimpl;

import com.beautyandhealth.entity.Customer;
import com.beautyandhealth.exception.CustomerNotFoundException;
import com.beautyandhealth.repository.CustomerRepository;

import java.util.List;

public abstract class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findByContact(String contact) {

        for(Customer customer: findAll()){
            if(customer.getContact().equals(contact)){
                return customer;
            }
        }
        return null;
    }
}
