package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.VoucherUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("voucherUserRepository")
public interface VoucherUserRepository extends JpaRepository<VoucherUserEntity, String> {
    String VOUCHER_USER_REPOSITORY = "voucherUserRepository";
}
