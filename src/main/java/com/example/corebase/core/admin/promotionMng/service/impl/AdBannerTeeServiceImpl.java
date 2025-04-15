package com.example.corebase.core.admin.promotionMng.service.impl;

import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerTeeReq;
import com.example.corebase.core.admin.promotionMng.repository.AdBannerTeeRepository;
import com.example.corebase.core.admin.promotionMng.service.AdBannerTeeService;
import com.example.corebase.core.base.model.PageableObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdBannerTeeServiceImpl implements AdBannerTeeService {

    @Autowired
    private AdBannerTeeRepository repository;

    @Override
    public PageableObject<AdBannerTeeResDTO> getPageData(AdBannerFilterReq req) {
        return null;
    }

    @Override
    public AdBannerTeeDetailDTO getDataDetail(String id) {
        return null;
    }

    @Override
    public Boolean saveData(AdBannerTeeReq req) {
        return null;
    }

    @Override
    public Boolean removeData(String id) {
        return null;
    }
}
