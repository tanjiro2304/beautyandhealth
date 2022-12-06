package com.beautyandhealth.service;

import com.beautyandhealth.dto.CustomerDto;
import com.beautyandhealth.entity.Customer;
import com.beautyandhealth.exception.CustomerNotFoundException;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface CustomerService {

    Customer getContact(String phone) throws CustomerNotFoundException;

    List<Customer> findAll();

    Boolean ifUserExists(String userName, String password);
}
