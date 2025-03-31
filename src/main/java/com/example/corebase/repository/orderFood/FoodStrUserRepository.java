package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodStrUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodStrUserRepository extends JpaRepository<FoodStrUserEntity, String> {
}
