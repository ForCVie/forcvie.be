package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodStrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("foodStrRepository")
public interface FoodStrRepository extends JpaRepository<FoodStrEntity, String> {
    String FOOD_STR_REPOSITORY = "foodStrRepository";
}
