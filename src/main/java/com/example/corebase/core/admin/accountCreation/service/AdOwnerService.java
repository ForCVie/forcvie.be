package com.example.corebase.core.admin.accountCreation.service;

import com.example.corebase.core.admin.accountCreation.model.dto.AdOwnerDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdOwnerResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdOwnerFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdOwnerRequest;
import com.example.corebase.core.base.model.PageableObject;

public interface AdOwnerService {

    PageableObject<AdOwnerResDTO> getPageData(AdOwnerFilterRequest req);

    AdOwnerDetailDTO getDataDetail(String id);

    Boolean saveData(AdOwnerRequest req);

    Boolean removeData(String id);
}
