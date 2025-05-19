package com.example.corebase.core.admin.accountCreation.controller;

import com.example.corebase.core.admin.accountCreation.model.request.AdOwnerFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdOwnerRequest;
import com.example.corebase.core.admin.accountCreation.service.AdOwnerService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/account-creation/owner-mng")
public class AdOwnerController {

    @Autowired
    private AdOwnerService service;

    /**
     * Get Page Owner
     * @api /a/account-creation/owner-mng/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageData(@RequestBody AdOwnerFilterRequest req) {
        return new ResponseObject(service.getPageData(req));
    }

    /**
     * Get Detail Owner
     * @api /a/account-creation/owner-mng/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getDataDetail(@RequestBody String req) {
        return new ResponseObject(service.getDataDetail(req));
    }

    /**
     * Save Owner
     * @api /a/account-creation/owner-mng/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject saveData(@RequestBody AdOwnerRequest req) {
        return new ResponseObject(service.saveData(req));
    }

    /**
     * Remove Owner
     * @api /a/account-creation/owner-mng/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject removeData(@RequestBody String req) {
        return new ResponseObject(service.removeData(req));
    }
}
