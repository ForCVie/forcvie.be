package com.example.corebase.core.admin.accountCreation.repository;

import com.example.corebase.entity.auth.OwnerEntity;
import com.example.corebase.repository.auth.OwnerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AdOwnerRepository extends OwnerRepository {

    Page<OwnerEntity> findByUserNameContainsAndDelYn(String userName, String delYn, Pageable pageable);
}
