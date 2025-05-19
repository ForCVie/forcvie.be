package com.example.corebase.core.admin.accountCreation.service.impl;

import com.example.corebase.core.admin.accountCreation.model.dto.AdClientDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdClientResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdClientFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdClientMngRequest;
import com.example.corebase.core.admin.accountCreation.repository.AdClientMngRepository;
import com.example.corebase.core.admin.accountCreation.service.AdClientMngService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.auth.UserEntity;
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

@Service
public class AdClientMngServiceImpl implements AdClientMngService {

    @Autowired
    private AdClientMngRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Override
    public PageableObject<AdClientResDTO> getPageData(AdClientFilterRequest req) {
        Page<AdClientResDTO> dataResult = repository
                .findByUserNameContainsAndDelYn(req.getFullName(), Constants.STATE_N, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdClientResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdClientDetailDTO getDataDetail(String id) {
        UserEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(entity, AdClientDetailDTO.class);
    }

    @Override
    public Boolean saveData(AdClientMngRequest req) {
        UserEntity userEntity = modelMapper.map(req, UserEntity.class);

        if (StringUtils.isEmpty(userEntity.getId())) {
            userEntity.setId(sequencesUtil
                    .generateSequence(SequencesConstant.USER_MNG.getPrefix(),
                            SequencesConstant.USER_MNG.getTableName()));
        }

        repository.save(userEntity);
        return true;
    }

    @Override
    public Boolean removeData(String id) {
        UserEntity userEntity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        userEntity.setDelYn(Constants.STATE_Y);

        repository.save(userEntity);
        return true;
    }
}
