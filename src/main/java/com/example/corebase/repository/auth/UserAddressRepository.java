package com.example.corebase.repository.auth;

import com.example.corebase.entity.auth.UserAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userAddressRepository")
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, String> {
    String USER_ADDRESS_REPOSITORY_NAME = "userAddressRepository";
}
