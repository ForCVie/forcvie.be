package com.example.corebase.core.admin.accountCreation.controller;

import com.example.corebase.core.admin.accountCreation.model.request.AdClientFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdClientMngRequest;
import com.example.corebase.core.admin.accountCreation.service.AdClientMngService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/account-creation/client-mng")
public class AdClientMngController {

    @Autowired
    private AdClientMngService service;

    /**
     * Get Page Client
     * @api /a/account-creation/client-mng/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageData(@RequestBody AdClientFilterRequest req) {
        return new ResponseObject(service.getPageData(req));
    }

    /**
     * Get Detail Client
     * @api /a/account-creation/client-mng/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getDataDetail(@RequestBody String req) {
        return new ResponseObject(service.getDataDetail(req));
    }

    /**
     * Save Client
     * @api /a/account-creation/client-mng/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject saveData(@RequestBody AdClientMngRequest req) {
        return new ResponseObject(service.saveData(req));
    }

    /**
     * Remove Client
     * @api /a/account-creation/client-mng/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject removeData(@RequestBody String req) {
        return new ResponseObject(service.removeData(req));
    }
}
