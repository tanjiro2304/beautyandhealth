package com.beautyandhealth.repository;

import com.beautyandhealth.entity.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedItemsRepository extends JpaRepository<OrderedItems,String> {
}
