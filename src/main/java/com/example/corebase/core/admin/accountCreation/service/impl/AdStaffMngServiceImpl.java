package com.example.corebase.core.admin.accountCreation.service.impl;

import com.example.corebase.core.admin.accountCreation.model.dto.AdStaffMngDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdStaffMngResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdStaffFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdStaffMngRequest;
import com.example.corebase.core.admin.accountCreation.repository.AdStaffMngRepository;
import com.example.corebase.core.admin.accountCreation.service.AdStaffMngService;
import com.example.corebase.core.base.model.PageableObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdStaffMngServiceImpl implements AdStaffMngService {

    @Autowired
    private AdStaffMngRepository repository;

    @Override
    public PageableObject<AdStaffMngResDTO> getPageData(AdStaffFilterRequest req) {
        return null;
    }

    @Override
    public AdStaffMngDetailDTO getDataDetail(String id) {
        return null;
    }

    @Override
    public Boolean saveData(AdStaffMngRequest req) {
        return null;
    }

    @Override
    public Boolean removeData(String id) {
        return null;
    }
}
