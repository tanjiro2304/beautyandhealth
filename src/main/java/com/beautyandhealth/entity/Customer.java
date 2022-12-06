package com.beautyandhealth.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="first_name")
    private String fName;
    @Column(name="last_name")
    private String lName;
    @Column(name="phone_number")
    private String contact;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @OneToMany(mappedBy="customer")
    private List<Order> listOfOrders;
}
