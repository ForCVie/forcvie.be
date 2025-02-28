package com.example.corebase.core.admin.developer.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdRoleRequest {

    private String roleId;

    private String roleNm;

    private String roleDesc;

    private String roleSiteCd;

    private String roleCd;

    private List<String> listMenu;
}
