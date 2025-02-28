package com.example.corebase.entity;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "menu_cook")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MenuCookEntity extends AuditEntity implements Serializable {

    @Id
    private String menuCookSeq;

    private String title;

    private String description;

    private String header;

    private String footer;

    private String useYn;

    private String saveTemp;
}
