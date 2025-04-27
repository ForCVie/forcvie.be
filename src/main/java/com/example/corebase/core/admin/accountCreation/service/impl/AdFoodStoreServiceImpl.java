package com.example.corebase.core.admin.accountCreation.service.impl;

import com.example.corebase.core.admin.accountCreation.model.dto.AdFoodStoreDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdFoodStoreResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdFoodStoreFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdFoodStoreRequest;
import com.example.corebase.core.admin.accountCreation.service.AdFoodStoreService;
import com.example.corebase.core.base.model.PageableObject;
import org.springframework.stereotype.Service;

@Service
public class AdFoodStoreServiceImpl implements AdFoodStoreService {

    @Override
    public PageableObject<AdFoodStoreResDTO> getPageData(AdFoodStoreFilterRequest req) {
        return null;
    }

    @Override
    public AdFoodStoreDetailDTO getDataDetail(String id) {
        return null;
    }

    @Override
    public Boolean saveData(AdFoodStoreRequest req) {
        return null;
    }

    @Override
    public Boolean removeData(String id) {
        return null;
    }
}
