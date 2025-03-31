package com.example.corebase.repository.common;

import com.example.corebase.entity.common.NotificationMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationMngRepository extends JpaRepository<NotificationMngEntity, String> {
}
