package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodOrderEmployEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderEmployRepository extends JpaRepository<FoodOrderEmployEntity, String> {
}
