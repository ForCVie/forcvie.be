package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodStrUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("foodStrUserRepository")
public interface FoodStrUserRepository extends JpaRepository<FoodStrUserEntity, String> {
    String FOOD_STR_USER_REPOSITORY = "foodStrUserRepository";
}
