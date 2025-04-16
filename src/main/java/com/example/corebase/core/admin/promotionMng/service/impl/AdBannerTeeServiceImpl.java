package com.example.corebase.core.admin.promotionMng.service.impl;

import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeConDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerTeeFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerTeeReq;
import com.example.corebase.core.admin.promotionMng.repository.AdBannerTeeRepository;
import com.example.corebase.core.admin.promotionMng.service.AdBannerTeeService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.promotional.BannerTeeEntity;
import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.infrastructure.constant.SequencesConstant;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.pageCommon.PageableCommon;
import com.example.corebase.util.sequenceCommon.SequencesUtil;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AdBannerTeeServiceImpl implements AdBannerTeeService {

    @Autowired
    private AdBannerTeeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Override
    public PageableObject<AdBannerTeeResDTO> getPageData(AdBannerTeeFilterReq req) {
        Page<AdBannerTeeResDTO> dataResult = repository
                .getPageBannerTee(req, new AdBannerTeeConDTO(), PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdBannerTeeResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdBannerTeeDetailDTO getDataDetail(String id) {
        BannerTeeEntity bannerEntity = repository.findByBannerTeeSeqAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(bannerEntity, AdBannerTeeDetailDTO.class);
    }

    @Override
    @Transactional
    public Boolean saveData(AdBannerTeeReq req) {
        BannerTeeEntity bannerEntity = modelMapper.map(req, BannerTeeEntity.class);

        if (StringUtils.isEmpty(bannerEntity.getBannerTeeSeq())) {
            bannerEntity.setBannerTeeSeq(sequencesUtil
                    .generateSequence(SequencesConstant.BANNER.getPrefix(),
                            SequencesConstant.BANNER.getTableName()));
        }
        repository.save(bannerEntity);
        return true;
    }

    @Override
    public Boolean removeData(String id) {
        BannerTeeEntity bannerEntity = repository.findByBannerTeeSeqAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        bannerEntity.setDelYn(Constants.STATE_Y);
        repository.save(bannerEntity);
        return true;
    }
}
