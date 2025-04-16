package com.example.corebase.core.admin.promotionMng.service;

import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdPopupNoticeFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdPopupNoticeReq;
import com.example.corebase.core.base.model.PageableObject;

public interface AdPopupNoticeService {

    PageableObject<AdPopupNoticeResDTO> getPageData(AdPopupNoticeFilterReq req);

    AdPopupNoticeDetailDTO getDataDetail(String id);

    Boolean saveData(AdPopupNoticeReq req);

    Boolean removeData(String id);
}
