package com.example.corebase.core.admin.promotionMng.service;

import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerTeeFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerTeeReq;
import com.example.corebase.core.base.model.PageableObject;

public interface AdBannerTeeService {

    PageableObject<AdBannerTeeResDTO> getPageData(AdBannerTeeFilterReq req);

    AdBannerTeeDetailDTO getDataDetail(String id);

    Boolean saveData(AdBannerTeeReq req);

    Boolean removeData(String id);
}
