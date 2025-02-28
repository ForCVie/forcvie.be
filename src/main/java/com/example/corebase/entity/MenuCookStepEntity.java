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

@Table(name = "menu_cook_step")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MenuCookStepEntity extends AuditEntity implements Serializable {

    @Id
    private String menuCookStepSeq;

    private String content;

    private String useYn;

    private String stepOrder;

    private String delYn;

    private String title;
}
