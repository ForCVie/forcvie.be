package com.example.corebase.repository;

import com.example.corebase.entity.HashtagMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagMngRepository extends JpaRepository<HashtagMngEntity, String> {
}
