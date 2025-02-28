package com.example.corebase.repository;

import com.example.corebase.entity.FoodStrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodStrRepository extends JpaRepository<FoodStrEntity, String> {
}
