package com.example.corebase.repository;

import com.example.corebase.entity.FoodOrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderDetailRepository extends JpaRepository<FoodOrderDetailEntity, String> {
}
