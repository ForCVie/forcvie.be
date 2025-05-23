package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodOrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("foodOrderDetailRepository")
public interface FoodOrderDetailRepository extends JpaRepository<FoodOrderDetailEntity, String> {
    String FOOD_ORDER_DETAIL_REPOSITORY = "foodOrderDetailRepository";
}
