package com.example.corebase.core.admin.fqaMng.service;

import com.example.corebase.core.admin.fqaMng.model.dto.AdNoticeDetailDTO;
import com.example.corebase.core.admin.fqaMng.model.dto.AdNoticeFormDTO;
import com.example.corebase.core.admin.fqaMng.model.dto.AdNoticeResDTO;
import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeFilterReq;
import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeReq;
import com.example.corebase.core.base.model.PageableObject;

public interface AdNoticeService {

    PageableObject<AdNoticeResDTO> getPageData(AdNoticeFilterReq req);

    AdNoticeDetailDTO getDataDetail(String id);

    Boolean saveData(AdNoticeReq req);

    Boolean removeData(String id);

    Boolean setNoticeUp(String id);

    Boolean setNoticeDown(String id);

    AdNoticeFormDTO getFormData();
}
