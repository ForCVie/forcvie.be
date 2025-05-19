package com.example.corebase.core.admin.accountCreation.controller;

import com.example.corebase.core.admin.accountCreation.model.request.AdStaffFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdStaffMngRequest;
import com.example.corebase.core.admin.accountCreation.service.AdStaffMngService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/account-creation/staff-mng")
public class AdStaffMngController {

    @Autowired
    private AdStaffMngService service;

    /**
     * Get Page Staff
     * @api /a/account-creation/staff-mng/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageData(@RequestBody AdStaffFilterRequest req) {
        return new ResponseObject(service.getPageData(req));
    }

    /**
     * Get Detail Staff
     * @api /a/account-creation/staff-mng/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getDataDetail(@RequestBody String req) {
        return new ResponseObject(service.getDataDetail(req));
    }

    /**
     * Save Staff
     * @api /a/account-creation/staff-mng/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject saveData(@RequestBody AdStaffMngRequest req) {
        return new ResponseObject(service.saveData(req));
    }

    /**
     * Remove Staff
     * @api /a/account-creation/staff-mng/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject removeData(@RequestBody String req) {
        return new ResponseObject(service.removeData(req));
    }
}
