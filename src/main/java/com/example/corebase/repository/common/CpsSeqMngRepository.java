package com.example.corebase.repository.common;

import com.example.corebase.entity.common.CpsSeqMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpsSeqMngRepository extends JpaRepository<CpsSeqMngEntity, String> {
}
