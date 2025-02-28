package com.example.corebase.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.corebase.entity.auth.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
