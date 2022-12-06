package com.beautyandhealth.converter;

import com.beautyandhealth.dto.CustomerDto;
import com.beautyandhealth.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerConverter {

    public static CustomerDto convertToDto(Customer customer){
        return CustomerDto.builder().customerId(customer.getCustomerId())
                .fName(customer.getFName())
                .lName(customer.getLName())
                .email(customer.getEmail())
                .contact(customer.getContact())
                .password(customer.getPassword())
                .build();
    }

    public static List<CustomerDto> convertToDtoList(List<Customer> all) {
        return all.stream().map(CustomerConverter::convertToDto).collect(Collectors.toList());
    }
}
