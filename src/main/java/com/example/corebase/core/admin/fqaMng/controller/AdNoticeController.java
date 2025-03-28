package com.example.corebase.core.admin.fqaMng.controller;

import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeFilterReq;
import com.example.corebase.core.admin.fqaMng.model.request.AdNoticeReq;
import com.example.corebase.core.admin.fqaMng.service.AdNoticeService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/fqa/notice")
public class AdNoticeController {

    @Autowired
    private AdNoticeService service;

    /**
     * Get Page Notice
     * @api /a/fqa/notice/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageData(@RequestBody AdNoticeFilterReq req) {
        return new ResponseObject(service.getPageData(req));
    }

    /**
     * Get Detail Notice
     * @api /a/fqa/notice/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getDataDetail(@RequestBody String req) {
        return new ResponseObject(service.getDataDetail(req));
    }

    /**
     * Save Notice
     * @api /a/fqa/notice/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject saveData(@RequestBody AdNoticeReq req) {
        return new ResponseObject(service.saveData(req));
    }

    /**
     * Save Notice
     * @api /a/fqa/notice/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject removeData(@RequestBody String req) {
        return new ResponseObject(service.removeData(req));
    }

    /**
     * Up Notice
     * @api /a/fqa/notice/set-up
     * @param req
     * @return
     */
    @PostMapping("/set-up")
    public ResponseObject setNoticeUp(@RequestBody String req) {
        return new ResponseObject(service.setNoticeUp(req));
    }

    /**
     * Down Notice
     * @api /a/fqa/notice/set-down
     * @param req
     * @return
     */
    @PostMapping("/set-down")
    public ResponseObject setNoticeDown(@RequestBody String req) {
        return new ResponseObject(service.setNoticeDown(req));
    }

    /**
     * Get Data Form Notice
     * @api /a/fqa/notice/form
     * @param
     * @return
     */
    @PostMapping("/form")
    public ResponseObject getDataForm() {
        return new ResponseObject(service.getFormData());
    }
}
