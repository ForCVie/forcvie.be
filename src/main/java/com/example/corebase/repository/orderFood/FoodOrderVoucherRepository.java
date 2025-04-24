package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FoodOrderVoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("foodOrderVoucherRepository")
public interface FoodOrderVoucherRepository extends JpaRepository<FoodOrderVoucherEntity, String> {
    String FOOD_ORDER_VOUCHER_REPOSITORY = "foodOrderVoucherRepository";
}
