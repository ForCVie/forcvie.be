package com.example.corebase.core.admin.developer.service.impl;

import com.example.corebase.core.admin.developer.model.dto.AdResourceDetailDTO;
import com.example.corebase.core.admin.developer.model.dto.AdResourceResDTO;
import com.example.corebase.core.admin.developer.model.request.AdResourceFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdResourceRequest;
import com.example.corebase.core.admin.developer.repository.AdResourceRepository;
import com.example.corebase.core.admin.developer.service.AdResourceService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.system.SysResourceEntity;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.pageCommon.PageableCommon;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AdResourceServiceImpl implements AdResourceService {

    @Autowired
    private AdResourceRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public PageableObject<AdResourceResDTO> getPageData(AdResourceFilterRequest req) {
        Page<AdResourceResDTO> dataResult = repository
                .findByUrlContainsAndRsNmContainsAndHttpMethodContainsAndRsTypeContainsOrderByIdDesc(req.getUrl(), req.getRsNm(), req.getHttpMethod(), req.getRsType(), PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdResourceResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdResourceDetailDTO getDetailData(Long id) {
        SysResourceEntity dataDetail = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(dataDetail, AdResourceDetailDTO.class);
    }

    @Override
    @Transactional
    public Boolean saveData(AdResourceRequest req) {
        SysResourceEntity dataSave = modelMapper.map(req, SysResourceEntity.class);

        repository.save(dataSave);
        return true;
    }

    @Override
    @Transactional
    public Boolean removeData(Long id) {
        repository.deleteById(id);
        return true;
    }
}
