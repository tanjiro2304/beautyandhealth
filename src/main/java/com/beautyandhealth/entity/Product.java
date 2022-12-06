package com.beautyandhealth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name="product_id")
    private String productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="category")
    private String Category;
    @Column(name="price")
    private Integer price;
    @Column(name="brand")
    private String brand;

}
