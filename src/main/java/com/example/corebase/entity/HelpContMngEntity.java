package com.example.corebase.entity;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Table (name = "help_cont_mng")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HelpContMngEntity extends AuditEntity implements Serializable {

    @Id
    private String helpContMngSeq;

    private String title;

    private String content;

    private Integer helpMngSeq;

}
