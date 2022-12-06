package com.beautyandhealth.repository;

import com.beautyandhealth.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
