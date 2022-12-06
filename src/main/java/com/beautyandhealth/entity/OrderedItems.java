package com.beautyandhealth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderedItems {
    @Id
    @Column(name="orderedItem_id")
    private String orderedItemId;
    @ManyToOne
    private Order placedOrder;
    @OneToOne
    private Product product;
    @Column(name="orderedItem_name")
    private String orderedItemName;
    @Column(name="quantity")
    private int quantity;
    @Column(name="orderedItem_price")
    private Integer orderedItemPrice;

}
