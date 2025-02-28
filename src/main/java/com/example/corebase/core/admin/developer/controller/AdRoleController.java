package com.example.corebase.core.admin.developer.controller;

import com.example.corebase.core.admin.developer.model.request.AdRoleFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdRoleRequest;
import com.example.corebase.core.admin.developer.service.AdRoleService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/developer/role-mng")
public class AdRoleController {

    @Autowired
    private AdRoleService service;

    /**
     * Get Page Role
     * @api /a/developer/role-mng/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageData(@RequestBody AdRoleFilterRequest req) {
        return new ResponseObject(service.getPageData(req));
    }

    /**
     * Get Detail Role
     * @api /a/developer/role-mng/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getDataDetail(@RequestBody String req) {
        return new ResponseObject(service.getDataDetail(req));
    }

    /**
     * Save Role
     * @api /a/developer/role-mng/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject saveData(@RequestBody AdRoleRequest req) {
        return new ResponseObject(service.saveData(req));
    }

    /**
     * Remove Detail Role
     * @api /a/developer/role-mng/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject removeData(@RequestBody String req) {
        return new ResponseObject(service.removeData(req));
    }

    /**
     * Get Data Form Role
     * @api /a/developer/role-mng/form
     * @param
     * @return
     */
    @PostMapping("/form")
    public ResponseObject getDataForm(@RequestBody String siteCd) {
        return new ResponseObject(service.getFormData(siteCd));
    }
}
