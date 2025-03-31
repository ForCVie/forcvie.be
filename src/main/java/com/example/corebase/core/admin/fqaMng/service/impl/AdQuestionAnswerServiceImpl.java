package com.example.corebase.core.admin.fqaMng.service.impl;

import com.example.corebase.core.admin.fqaMng.model.dto.AdQuestionAnswerConDTO;
import com.example.corebase.core.admin.fqaMng.model.dto.AdQuestionAnswerDetailDTO;
import com.example.corebase.core.admin.fqaMng.model.dto.AdQuestionAnswerResDTO;
import com.example.corebase.core.admin.fqaMng.model.request.AdQuestionAnswerFilterReq;
import com.example.corebase.core.admin.fqaMng.model.request.AdQuestionAnswerReq;
import com.example.corebase.core.admin.fqaMng.repository.AdQuestionAnswerRepository;
import com.example.corebase.core.admin.fqaMng.service.AdQuestionAnswerService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.fqa.QAEntity;
import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.pageCommon.PageableCommon;
import com.example.corebase.util.userLogin.UserLoginUtil;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdQuestionAnswerServiceImpl implements AdQuestionAnswerService {

    @Autowired
    private AdQuestionAnswerRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private UserLoginUtil userLogin;

    @Override
    public PageableObject<AdQuestionAnswerResDTO> getPageData(AdQuestionAnswerFilterReq req) {
        Page<AdQuestionAnswerResDTO> dataResult = repository
                .getPageData(req, new AdQuestionAnswerConDTO(), PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdQuestionAnswerResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdQuestionAnswerDetailDTO getDataDetail(String id) {
        QAEntity qaEntity = repository.findByQaSeqAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(qaEntity, AdQuestionAnswerDetailDTO.class);
    }

    @Override
    @Transactional
    public Boolean saveData(AdQuestionAnswerReq req) {
        QAEntity qaEntity = repository.findByQaSeqAndDelYn(req.getQaSeq(), Constants.STATE_N)
            .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        qaEntity.setAnswer(req.getAnswer());
        qaEntity.setUserAnswer(userLogin.getUserLogin().getId());
        qaEntity.setStatus(Constants.Q_A_STATUS_ANSWER);
        qaEntity.setAnswerDate(LocalDateTime.now());
        repository.save(qaEntity);
        return true;
    }

    @Override
    @Transactional
    public Boolean rejectQuestion(String id) {
        QAEntity qaEntity = repository.findByQaSeqAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        qaEntity.setStatus(Constants.Q_A_STATUS_REJECT);
        repository.save(qaEntity);
        return null;
    }
}
