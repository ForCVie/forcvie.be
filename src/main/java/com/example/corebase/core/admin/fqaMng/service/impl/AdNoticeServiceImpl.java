package com.example.corebase.core.admin.fqaMng.service.impl;

import com.example.corebase.core.admin.developer.repository.AdRoleRepository;
import com.example.corebase.core.admin.fqaMng.model.dto.AdNoticeDetailDTO;
import com.example.corebase.core.admin.fqaMng.model.dto.AdNoticeFormDTO;
import com.example.corebase.core.admin.fqaMng.model.dto.AdNoticeResDTO;
import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeFilterReq;
import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeReq;
import com.example.corebase.core.admin.fqaMng.repository.AdNoticeRepository;
import com.example.corebase.core.admin.fqaMng.service.AdNoticeService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.common.service.dto.CodeMngDTO;
import com.example.corebase.entity.fqa.NoticeEntity;
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

import java.util.List;

@Service
public class AdNoticeServiceImpl implements AdNoticeService {

    @Autowired
    private AdNoticeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Autowired
    private AdRoleRepository roleRepository;

    @Override
    public PageableObject<AdNoticeResDTO> getPageData(AdNoticeFilterReq req) {
        Page<AdNoticeResDTO> dataResult = repository
                .getPageData(req, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdNoticeResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdNoticeDetailDTO getDataDetail(String id) {
        NoticeEntity response = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(response, AdNoticeDetailDTO.class);
    }

    @Override
    public Boolean saveData(AdNoticeReq req) {
        NoticeEntity menuEntity = modelMapper.map(req, NoticeEntity.class);

        if (StringUtils.isEmpty(menuEntity.getNoticeSeq())) {
            menuEntity.setNoticeSeq(sequencesUtil
                    .generateSequence(SequencesConstant.NOTICE.getPrefix(),
                            SequencesConstant.NOTICE.getTableName()));
        }

        repository.save(menuEntity);
        return true;
    }

    @Override
    public Boolean removeData(String id) {
        NoticeEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));
        entity.setDelYn(Constants.STATE_Y);
        repository.save(entity);
        return true;
    }

    @Override
    public Boolean setNoticeUp(String id) {
        NoticeEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));
        entity.setTopFixCd(Constants.NOTICE_TOP);
        repository.save(entity);
        return true;
    }

    @Override
    public Boolean setNoticeDown(String id) {
        NoticeEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));
        entity.setTopFixCd(Constants.NOTICE_DOWN);
        repository.save(entity);
        return true;
    }

    @Override
    public AdNoticeFormDTO getFormData() {
        AdNoticeFormDTO noticeForm = new AdNoticeFormDTO();

        List<CodeMngDTO> listRole = roleRepository.findAll()
                .stream().map(item -> new CodeMngDTO(item.getRoleId(), "ROLE_CD", item.getRoleNm())).toList();
        noticeForm.setListRole(listRole);
        return noticeForm;
    }
}
