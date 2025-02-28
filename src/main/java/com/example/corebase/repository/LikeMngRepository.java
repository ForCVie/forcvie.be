package com.example.corebase.repository;

import com.example.corebase.entity.LikeMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeMngRepository extends JpaRepository<LikeMngEntity, String> {
}
