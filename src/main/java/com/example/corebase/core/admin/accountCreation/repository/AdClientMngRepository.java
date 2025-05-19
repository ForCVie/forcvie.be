package com.example.corebase.core.admin.accountCreation.repository;

import com.example.corebase.entity.auth.UserEntity;
import com.example.corebase.repository.auth.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdClientMngRepository extends UserRepository {

    Page<UserEntity> findByUserNameContainsAndDelYn(String userName, String delYn, Pageable pageable);
}
