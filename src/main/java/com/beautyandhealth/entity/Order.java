package com.beautyandhealth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_order")
public class Order {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(name="order_date")
    private Date orderDate;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "placedOrder")
    private List<OrderedItems> listOfOrderedItems;
}
