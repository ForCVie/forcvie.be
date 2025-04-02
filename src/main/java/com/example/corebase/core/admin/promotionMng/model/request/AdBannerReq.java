package com.example.corebase.core.admin.promotionMng.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdBannerReq {

    private String bannerSeq;

    private String bannerNm;

    private String useYn;

    private String url;

    private String bannerType;
}
