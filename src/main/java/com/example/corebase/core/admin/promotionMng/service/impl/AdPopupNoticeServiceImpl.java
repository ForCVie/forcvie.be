package com.example.corebase.core.admin.promotionMng.service.impl;

import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeConDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdPopupNoticeFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdPopupNoticeReq;
import com.example.corebase.core.admin.promotionMng.repository.AdPopupNoticeRepository;
import com.example.corebase.core.admin.promotionMng.service.AdPopupNoticeService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.promotional.PopupNoticeEntity;
import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.infrastructure.constant.SequencesConstant;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.pageCommon.PageableCommon;
import com.example.corebase.util.sequenceCommon.SequencesUtil;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Page<AdPopupNoticeResDTO> dataResult = repository
                .getPagePopupNotice(req, new AdPopupNoticeConDTO(), PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdPopupNoticeResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdPopupNoticeDetailDTO getDataDetail(String id) {
        PopupNoticeEntity popupNotice = repository.findByPopupNoticeSeqAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(popupNotice, AdPopupNoticeDetailDTO.class);
    }

    @Override
    @Transactional
    public String saveData(AdPopupNoticeReq req) {
        PopupNoticeEntity popupNoticeEntity = modelMapper.map(req, PopupNoticeEntity.class);

        if (StringUtils.isEmpty(popupNoticeEntity.getPopupNoticeSeq())) {
            popupNoticeEntity.setPopupNoticeSeq(sequencesUtil
                    .generateSequence(SequencesConstant.POPUP_NOTICE.getPrefix(),
                            SequencesConstant.POPUP_NOTICE.getTableName()));
        }
        repository.save(popupNoticeEntity);
        return popupNoticeEntity.getPopupNoticeSeq();
    }

    @Override
    @Transactional
    public Boolean removeData(String id) {
        PopupNoticeEntity popupNotice = repository.findByPopupNoticeSeqAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        popupNotice.setDelYn(Constants.STATE_Y);
        repository.save(popupNotice);
        return true;
    }
}
