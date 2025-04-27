package com.example.corebase.core.admin.accountCreation.repository;

import com.example.corebase.entity.auth.StaffEntity;
import com.example.corebase.repository.auth.StaffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AdStaffMngRepository extends StaffRepository {

    Page<StaffEntity> findByFullNameContainsAndDelYn(String fullName, String delYn , Pageable pageable);
}
