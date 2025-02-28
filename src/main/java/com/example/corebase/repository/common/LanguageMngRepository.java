package com.example.corebase.repository.common;

import com.example.corebase.entity.common.LanguageMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageMngRepository extends JpaRepository<LanguageMngEntity, String> {
}
