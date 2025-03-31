package com.example.corebase.core.admin.promotionMng.service.impl;

import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerConDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerReq;
import com.example.corebase.core.admin.promotionMng.repository.AdBannerRepository;
import com.example.corebase.core.admin.promotionMng.service.AdBannerService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.promotional.BannerEntity;
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
public class AdBannerServiceImpl implements AdBannerService {

    @Autowired
    private AdBannerRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Override
    public PageableObject<AdBannerResDTO> getPageData(AdBannerFilterReq req) {
        Page<AdBannerResDTO> dataResult = repository
                .getPageAdBanner(req, new AdBannerConDTO(), PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdBannerResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdBannerDetailDTO getDataDetail(String id) {
        BannerEntity bannerEntity = repository.findByBannerSeqAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(bannerEntity, AdBannerDetailDTO.class);
    }

    @Override
    @Transactional
    public Boolean saveData(AdBannerReq req) {
        BannerEntity bannerEntity = modelMapper.map(req, BannerEntity.class);

        if (StringUtils.isEmpty(bannerEntity.getBannerSeq())) {
            bannerEntity.setBannerSeq(sequencesUtil
                    .generateSequence(SequencesConstant.BANNER.getPrefix(),
                            SequencesConstant.BANNER.getTableName()));
        }
        repository.save(bannerEntity);
        return true;
    }

    @Override
    @Transactional
    public Boolean removeData(String id) {
        BannerEntity bannerEntity = repository.findByBannerSeqAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        bannerEntity.setDelYn(Constants.STATE_Y);
        repository.save(bannerEntity);
        return true;
    }
}
