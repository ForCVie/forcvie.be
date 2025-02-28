package com.example.corebase.core.admin.promotionMng.service;

import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerReq;
import com.example.corebase.core.base.model.PageableObject;

public interface AdBannerService {

    PageableObject<AdBannerResDTO> getPageData(AdBannerFilterReq req);

    AdBannerDetailDTO getDataDetail(String id);

    Boolean saveData(AdBannerReq req);

    Boolean removeData(String id);
}
