package com.example.corebase.repository;

import com.example.corebase.entity.FoodOrderVoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderVoucherRepository extends JpaRepository<FoodOrderVoucherEntity, String> {
}
