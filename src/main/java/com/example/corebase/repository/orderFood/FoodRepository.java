package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("foodRepository")
public interface FoodRepository extends JpaRepository<FoodEntity, String> {
    String FOOD_REPOSITORY = "foodRepository";
}
