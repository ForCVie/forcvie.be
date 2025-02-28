package com.example.corebase.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Immutable
@Table(name = "CODE_MNG")
public class CodeMngEntity {

    @Id
    @Column(name = "cd_id")
    private String cdId;

    @Column(name = "up_cd_id")
    private String upCdId;

    @Column(name = "order_by")
    private String orderBy;

    @Column(name = "cd_name")
    private String cdName;

    @Column(name = "cd_key")
    private String cdKey;
}
