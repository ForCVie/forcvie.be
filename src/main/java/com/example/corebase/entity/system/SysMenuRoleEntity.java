package com.example.corebase.entity.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "menu_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SysMenuRoleEntity implements Serializable {

    @Id
    private String menuRoleSeq;

    private String menuId;

    private String roleId;

    private String status;
}
