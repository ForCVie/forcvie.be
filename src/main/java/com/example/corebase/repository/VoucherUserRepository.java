package com.example.corebase.repository;

import com.example.corebase.entity.VoucherUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherUserRepository extends JpaRepository<VoucherUserEntity, String> {
}
