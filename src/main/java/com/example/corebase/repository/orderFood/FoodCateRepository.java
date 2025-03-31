package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodCateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCateRepository extends JpaRepository<FoodCateEntity, String> {
}
