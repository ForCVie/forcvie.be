package com.example.corebase.core.admin.developer.service;

import com.example.corebase.core.admin.developer.model.dto.AdResourceDetailDTO;
import com.example.corebase.core.admin.developer.model.dto.AdResourceResDTO;
import com.example.corebase.core.admin.developer.model.request.AdResourceFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdResourceRequest;
import com.example.corebase.core.base.model.PageableObject;

public interface AdResourceService {

    PageableObject<AdResourceResDTO> getPageData(AdResourceFilterRequest req);

    AdResourceDetailDTO getDetailData(Long id);

    Boolean saveData(AdResourceRequest req);

    Boolean removeData(Long id);
}
