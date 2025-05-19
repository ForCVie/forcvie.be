package com.example.corebase.core.admin.accountCreation.service.impl;

import com.example.corebase.core.admin.accountCreation.model.dto.AdStaffMngDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdStaffMngResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdStaffFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdStaffMngRequest;
import com.example.corebase.core.admin.accountCreation.repository.AdStaffMngRepository;
import com.example.corebase.core.admin.accountCreation.service.AdStaffMngService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.auth.StaffEntity;
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
public class AdStaffMngServiceImpl implements AdStaffMngService {

    @Autowired
    private AdStaffMngRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Override
    public PageableObject<AdStaffMngResDTO> getPageData(AdStaffFilterRequest req) {
        Page<AdStaffMngResDTO> dataResult = repository
                .findByFullNameContainsAndDelYn(req.getFullName(), Constants.STATE_N, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdStaffMngResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdStaffMngDetailDTO getDataDetail(String id) {
        StaffEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(entity, AdStaffMngDetailDTO.class);
    }

    @Override
    public Boolean saveData(AdStaffMngRequest req) {
        StaffEntity staffEntity = modelMapper.map(req, StaffEntity.class);

        if (StringUtils.isEmpty(staffEntity.getId())) {
            staffEntity.setId(sequencesUtil
                    .generateSequence(SequencesConstant.STAFF_MNG.getPrefix(),
                            SequencesConstant.STAFF_MNG.getTableName()));
        }

        repository.save(staffEntity);
        return true;
    }

    @Override
    public Boolean removeData(String id) {
        StaffEntity staffEntity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        staffEntity.setDelYn(Constants.STATE_Y);

        repository.save(staffEntity);
        return true;
    }
}
