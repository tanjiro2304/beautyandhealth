package com.beautyandhealth.serviceimpl;

import com.beautyandhealth.converter.CustomerConverter;
import com.beautyandhealth.dto.CustomerDto;
import com.beautyandhealth.entity.Customer;
import com.beautyandhealth.exception.CustomerNotFoundException;
import com.beautyandhealth.repository.CustomerRepository;
import com.beautyandhealth.service.CustomerService;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UIScope
@SpringComponent
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getContact(String phone) throws CustomerNotFoundException {
        Customer findCustomerContact = customerRepository.findByContact(phone);

        return findCustomerContact;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Boolean ifUserExists(String userName, String password) {
        List<Customer> customerList = findAll();
        for (Customer c : customerList) {
            if (c.getEmail().equals(userName) && c.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }
}
