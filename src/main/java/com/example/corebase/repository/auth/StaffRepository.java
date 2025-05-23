package com.example.corebase.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.corebase.entity.auth.StaffEntity;

@Repository("staffRepository")
public interface StaffRepository extends JpaRepository<StaffEntity, String> {
    String STAFF_REPOSITORY = "staffRepository";
}
