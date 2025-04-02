package com.example.corebase.core.admin.promotionMng.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdBannerFilterReq extends PageableRequest {

    private String typeCd;

    private String bannerNm;

    private String useYn;

    private String url;
}
