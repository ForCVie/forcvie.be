package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("voucherRepository")
public interface VoucherRepository extends JpaRepository<VoucherEntity, String> {
    String VOUCHER_REPOSITORY = "voucherRepository";
}
