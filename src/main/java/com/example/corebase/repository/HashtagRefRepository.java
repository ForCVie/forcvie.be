package com.example.corebase.repository;

import com.example.corebase.entity.HashtagRefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRefRepository extends JpaRepository<HashtagRefEntity, String> {
}
