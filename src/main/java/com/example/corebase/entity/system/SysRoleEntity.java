package com.example.corebase.entity.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "sys_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SysRoleEntity implements Serializable {

    @Id
    private String roleId;

    private String roleNm;

    private String roleDesc;

    private String roleSiteCd;

    private String roleCd;
}
