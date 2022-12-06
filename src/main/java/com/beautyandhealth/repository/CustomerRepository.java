package com.beautyandhealth.repository;

import com.beautyandhealth.entity.Customer;
import com.beautyandhealth.exception.CustomerNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

public Customer findByContact(String contact);
public List<Customer> findAll();

}
