package com.example.corebase.repository;

import com.example.corebase.entity.FollowerMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerMngRepository extends JpaRepository<FollowerMngEntity, String> {
}
