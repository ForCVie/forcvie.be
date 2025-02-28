package com.example.corebase.repository.common;

import com.example.corebase.entity.common.FileMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileMngRepository extends JpaRepository<FileMngEntity, UUID> {
}
