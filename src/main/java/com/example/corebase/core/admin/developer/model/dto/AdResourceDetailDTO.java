package com.example.corebase.core.admin.developer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdResourceDetailDTO {

    private Long id;

    private String url;

    private String httpMethod;

    private String rsNm;

    private String rsType;

    private String status;

    private String category;

    private String site;

    private Long menuId;
}
