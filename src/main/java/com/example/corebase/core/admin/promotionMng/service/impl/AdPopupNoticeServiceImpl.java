package com.example.corebase.core.admin.promotionMng.service.impl;

import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdPopupNoticeFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdPopupNoticeReq;
import com.example.corebase.core.admin.promotionMng.repository.AdPopupNoticeRepository;
import com.example.corebase.core.admin.promotionMng.service.AdPopupNoticeService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.sequenceCommon.SequencesUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdPopupNoticeServiceImpl implements AdPopupNoticeService {

    @Autowired
    private AdPopupNoticeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Override
    public PageableObject<AdPopupNoticeResDTO> getPageData(AdPopupNoticeFilterReq req) {
        return null;
    }

    @Override
    public AdPopupNoticeDetailDTO getDataDetail(String id) {
        return null;
    }

    @Override
    public Boolean saveData(AdPopupNoticeReq req) {
        return null;
    }

    @Override
    public Boolean removeData(String id) {
        return null;
    }
}
