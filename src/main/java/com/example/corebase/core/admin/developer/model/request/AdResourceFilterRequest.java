package com.example.corebase.core.admin.developer.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdResourceFilterRequest extends PageableRequest {

    private String url;

    private String rsNm;

    private String httpMethod;

    private String rsType;
}
