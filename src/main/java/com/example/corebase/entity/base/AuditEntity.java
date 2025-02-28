package com.example.corebase.entity.base;

import com.example.corebase.infrastructure.listener.AuditEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
public abstract class AuditEntity {

    @Column
    private String delYn;

    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime lastModifiedDate;

    @Column(updatable = false)
    private String createdBy;

    @Column
    private String lastModifiedBy;
}
