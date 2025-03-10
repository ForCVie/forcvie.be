package com.example.corebase.core.admin.fqaMng.service.impl;

import com.example.corebase.core.admin.fqaMng.model.dto.AdNoticeDetailDTO;
import com.example.corebase.core.admin.fqaMng.model.dto.AdNoticeResDTO;
import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeFilterReq;
import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeReq;
import com.example.corebase.core.admin.fqaMng.repository.AdNoticeRepository;
import com.example.corebase.core.admin.fqaMng.service.AdNoticeService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.pageCommon.PageableCommon;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AdNoticeServiceImpl implements AdNoticeService {

    @Autowired
    private AdNoticeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public PageableObject<AdNoticeResDTO> getPageData(AdNoticeFilterReq req) {
        Page<AdNoticeResDTO> dataResult = repository
                .getPageData(req, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdNoticeResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdNoticeDetailDTO getDataDetail(String id) {
        return null;
    }

    @Override
    public Boolean saveData(AdNoticeReq req) {
        return null;
    }

    @Override
    public Boolean setNoticeUp(String id) {
        return null;
    }

    @Override
    public Boolean setNoticeDown(String id) {
        return null;
    }
}
