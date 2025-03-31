package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<VoucherEntity, String> {
}
