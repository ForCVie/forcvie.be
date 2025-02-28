package com.example.corebase.infrastructure.listener;

import com.example.corebase.entity.base.AuditEntity;
import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.util.userLogin.UserLoginUtil;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;

public class AuditEntityListener {

    @Autowired
    private UserLoginUtil util;

    @PrePersist
    private void onCreate(AuditEntity entity) {
        entity.setCreatedDate(LocalDateTime.now());
        entity.setCreatedBy(util.getUserLogin().getUserName());
        entity.setDelYn(Constants.STATE_N);
    }

    @PreUpdate
    private void onUpdate(AuditEntity entity) {
        entity.setLastModifiedDate(LocalDateTime.now());
        entity.setLastModifiedBy(util.getUserLogin().getUserName());
    }

    private Date getCurrentTime() {
        return new Date();
    }
}
