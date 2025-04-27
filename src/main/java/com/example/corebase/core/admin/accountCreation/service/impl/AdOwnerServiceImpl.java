package com.example.corebase.core.admin.accountCreation.service.impl;

import com.example.corebase.core.admin.accountCreation.model.dto.AdOwnerDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdOwnerResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdOwnerFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdOwnerRequest;
import com.example.corebase.core.admin.accountCreation.repository.AdOwnerRepository;
import com.example.corebase.core.admin.accountCreation.service.AdOwnerService;
import com.example.corebase.core.base.model.PageableObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdOwnerServiceImpl implements AdOwnerService {

    @Autowired
    private AdOwnerRepository repository;

    @Override
    public PageableObject<AdOwnerResDTO> getPageData(AdOwnerFilterRequest req) {
        return null;
    }

    @Override
    public AdOwnerDetailDTO getDataDetail(String id) {
        return null;
    }

    @Override
    public Boolean saveData(AdOwnerRequest req) {
        return null;
    }

    @Override
    public Boolean removeData(String id) {
        return null;
    }
}
