package com.example.corebase.core.admin.developer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdMenuDetailDTO {

    private String menuId;

    private String siteType;

    private String name;

    private String route;

    private String parentId;

    private String displayOrder;

    private String useYn;

    private String nm;
}
