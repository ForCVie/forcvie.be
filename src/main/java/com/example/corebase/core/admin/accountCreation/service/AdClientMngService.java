package com.example.corebase.core.admin.accountCreation.service;

import com.example.corebase.core.admin.accountCreation.model.dto.AdClientDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdClientResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdClientFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdClientMngRequest;
import com.example.corebase.core.base.model.PageableObject;

public interface AdClientMngService {

    PageableObject<AdClientResDTO> getPageData(AdClientFilterRequest req);

    AdClientDetailDTO getDataDetail(String id);

    Boolean saveData(AdClientMngRequest req);

    Boolean removeData(String id);
}
