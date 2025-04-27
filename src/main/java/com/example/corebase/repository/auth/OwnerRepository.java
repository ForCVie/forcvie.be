package com.example.corebase.repository.auth;

import com.example.corebase.entity.auth.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, String> {
}
