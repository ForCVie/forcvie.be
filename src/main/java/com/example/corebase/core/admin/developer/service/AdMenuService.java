package com.example.corebase.core.admin.developer.service;

import com.example.corebase.core.admin.developer.model.dto.AdMenuDetailDTO;
import com.example.corebase.core.admin.developer.model.dto.AdMenuForm;
import com.example.corebase.core.admin.developer.model.dto.AdMenuResDTO;
import com.example.corebase.core.admin.developer.model.request.AdMenuFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdMenuRequest;
import com.example.corebase.core.base.model.PageableObject;

import java.util.List;

public interface AdMenuService {

    PageableObject<AdMenuResDTO> getPageData(AdMenuFilterRequest req);

    AdMenuDetailDTO getDataDetail(String id);

    Boolean saveData(AdMenuRequest req);

    Boolean removeData(String id);

    AdMenuForm getDataForm(List<String> id);
}
