package com.example.corebase.core.admin.developer.service;

import com.example.corebase.core.admin.developer.model.dto.AdRoleDetailDTO;
import com.example.corebase.core.admin.developer.model.dto.AdRoleFormDTO;
import com.example.corebase.core.admin.developer.model.dto.AdRoleResDTO;
import com.example.corebase.core.admin.developer.model.request.AdRoleFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdRoleRequest;
import com.example.corebase.core.base.model.PageableObject;

public interface AdRoleService {

    PageableObject<AdRoleResDTO> getPageData(AdRoleFilterRequest req);

    AdRoleDetailDTO getDataDetail(String id);

    Boolean saveData(AdRoleRequest req);

    Boolean removeData(String id);

    AdRoleFormDTO getFormData(String siteCd);
}
