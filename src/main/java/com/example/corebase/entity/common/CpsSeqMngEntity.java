package com.example.corebase.entity.common;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cps_seq_mng")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CpsSeqMngEntity {

    @Id
    private String tblName;

    private String prefix;

    private String lastNum;
}
