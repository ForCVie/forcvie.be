package com.example.corebase.core.admin.developer.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdMenuRequest {

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
