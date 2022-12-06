package com.beautyandhealth.dto;

import com.beautyandhealth.entity.Order;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long customerId;

    private String fName;

    private String lName;

    private String contact;

    private String email;

    private String password;
}


