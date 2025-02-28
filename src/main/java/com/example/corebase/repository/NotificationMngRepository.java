package com.example.corebase.repository;

import com.example.corebase.entity.NotificationMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationMngRepository extends JpaRepository<NotificationMngEntity, String> {
}
