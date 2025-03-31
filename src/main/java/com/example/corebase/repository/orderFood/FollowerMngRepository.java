package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.FollowerMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerMngRepository extends JpaRepository<FollowerMngEntity, String> {
}
