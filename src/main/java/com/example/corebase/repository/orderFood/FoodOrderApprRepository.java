package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodOrderApprEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderApprRepository extends JpaRepository<FoodOrderApprEntity, String> {
}
