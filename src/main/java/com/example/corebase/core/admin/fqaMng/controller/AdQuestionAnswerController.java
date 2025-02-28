package com.example.corebase.core.admin.fqaMng.controller;

import com.example.corebase.core.admin.fqaMng.model.request.AdQuestionAnswerFilterReq;
import com.example.corebase.core.admin.fqaMng.model.request.AdQuestionAnswerReq;
import com.example.corebase.core.admin.fqaMng.service.AdQuestionAnswerService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/question-answer")
public class AdQuestionAnswerController {

    @Autowired
    private AdQuestionAnswerService service;

    /**
     * Get Page Question
     * @api /a/question-answer/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageData(@RequestBody AdQuestionAnswerFilterReq req) {
        return new ResponseObject(service.getPageData(req));
    }

    /**
     * Get Detail Question
     * @api /a/question-answer/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getDataDetail(@RequestBody String req) {
        return new ResponseObject(service.getDataDetail(req));
    }

    /**
     * Answer Question
     * @api /a/question-answer/answer
     * @param req
     * @return
     */
    @PostMapping("/answer")
    public ResponseObject saveData(@RequestBody AdQuestionAnswerReq req) {
        return new ResponseObject(service.saveData(req));
    }

    /**
     * Reject Question
     * @api /a/question-answer/reject
     * @param req
     * @return
     */
    @PostMapping("/reject")
    public ResponseObject rejectQuestion(@RequestBody String req) {
        return new ResponseObject(service.rejectQuestion(req));
    }
}
