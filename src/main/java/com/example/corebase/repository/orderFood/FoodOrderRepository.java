package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("foodOrderRepository")
public interface FoodOrderRepository extends JpaRepository<FoodOrderEntity, String> {
    String FOOD_ORDER_REPOSITORY = "foodOrderRepository";
}
