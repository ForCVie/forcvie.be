package com.example.corebase.core.admin.fqaMng.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdNoticeFilterReq extends PageableRequest {

    private String title;

    private String postCd;

    private String topFixCd;
}
