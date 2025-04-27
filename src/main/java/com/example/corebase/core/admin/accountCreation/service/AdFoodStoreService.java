package com.example.corebase.core.admin.accountCreation.service;

import com.example.corebase.core.admin.accountCreation.model.dto.AdFoodStoreDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdFoodStoreResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdFoodStoreFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdFoodStoreRequest;
import com.example.corebase.core.base.model.PageableObject;

public interface AdFoodStoreService {

    PageableObject<AdFoodStoreResDTO> getPageData(AdFoodStoreFilterRequest req);

    AdFoodStoreDetailDTO getDataDetail(String id);

    Boolean saveData(AdFoodStoreRequest req);

    Boolean removeData(String id);
}
