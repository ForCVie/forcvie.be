package com.example.corebase.entity.base;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class PrimaryBase extends AuditEntity implements IsIdentified {

    @Id
    private String id;
}
