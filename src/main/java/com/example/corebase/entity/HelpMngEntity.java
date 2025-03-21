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


@Table (name = "help_mng")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HelpMngEntity extends AuditEntity implements Serializable {

    @Id
    private String helpMngSeq;

    private String title;

    private Integer parentId;

    private Integer displayOrder;

    private String type;

}
