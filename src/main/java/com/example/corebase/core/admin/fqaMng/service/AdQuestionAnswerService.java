package com.example.corebase.core.admin.fqaMng.service;

import com.example.corebase.core.admin.fqaMng.model.dto.AdQuestionAnswerDetailDTO;
import com.example.corebase.core.admin.fqaMng.model.dto.AdQuestionAnswerResDTO;
import com.example.corebase.core.admin.fqaMng.model.request.AdQuestionAnswerFilterReq;
import com.example.corebase.core.admin.fqaMng.model.request.AdQuestionAnswerReq;
import com.example.corebase.core.base.model.PageableObject;

public interface AdQuestionAnswerService {

    PageableObject<AdQuestionAnswerResDTO> getPageData(AdQuestionAnswerFilterReq req);

    AdQuestionAnswerDetailDTO getDataDetail(String id);

    Boolean saveData(AdQuestionAnswerReq req);

    Boolean rejectQuestion(String id);
}
