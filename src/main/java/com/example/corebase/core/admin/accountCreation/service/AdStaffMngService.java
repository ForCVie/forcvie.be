package com.example.corebase.core.admin.accountCreation.service;

import com.example.corebase.core.admin.accountCreation.model.dto.AdStaffMngDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdStaffMngResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdStaffFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdStaffMngRequest;
import com.example.corebase.core.base.model.PageableObject;

public interface AdStaffMngService {

    PageableObject<AdStaffMngResDTO> getPageData(AdStaffFilterRequest req);

    AdStaffMngDetailDTO getDataDetail(String id);

    Boolean saveData(AdStaffMngRequest req);

    Boolean removeData(String id);
}
