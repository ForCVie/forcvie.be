package com.example.corebase.core.base.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuResDTO {

    private String menuId;

    private String name;

    private String route;

    private String parentId;

    private String nm;
}
