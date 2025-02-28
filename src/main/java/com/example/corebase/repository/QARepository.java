package com.example.corebase.repository;

import com.example.corebase.entity.QAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QARepository extends JpaRepository<QAEntity, String> {
}
