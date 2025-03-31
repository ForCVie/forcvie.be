package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrderEntity, String> {
}
