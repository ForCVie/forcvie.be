package com.example.corebase.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.corebase.entity.auth.UserEntity;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, String> {
    String USER_REPOSITORY_NAME = "userRepository";
}
