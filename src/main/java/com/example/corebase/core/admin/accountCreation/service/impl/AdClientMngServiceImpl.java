package com.example.corebase.core.admin.accountCreation.service.impl;

import com.example.corebase.core.admin.accountCreation.model.dto.AdClientDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdClientResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdClientFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdClientMngRequest;
import com.example.corebase.core.admin.accountCreation.repository.AdClientMngRepository;
import com.example.corebase.core.admin.accountCreation.service.AdClientMngService;
import com.example.corebase.core.base.model.PageableObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdClientMngServiceImpl implements AdClientMngService {

    @Autowired
    private AdClientMngRepository repository;

    @Override
    public PageableObject<AdClientResDTO> getPageData(AdClientFilterRequest req) {
        return null;
    }

    @Override
    public AdClientDetailDTO getDataDetail(String id) {
        return null;
    }

    @Override
    public Boolean saveData(AdClientMngRequest req) {
        return null;
    }

    @Override
    public Boolean removeData(String id) {
        return null;
    }
}
