package com.example.corebase.entity.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SysMenuEntity implements Serializable {

    @Id
    private String menuId;

    private String siteType;

    private String name;

    private String route;

    private String parentId;

    private String displayOrder;

    private String delYn;

    private String useYn;

    private String nm;
}
