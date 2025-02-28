package com.example.corebase.core.admin.developer.controller;

import com.example.corebase.core.admin.developer.model.request.AdResourceFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdResourceRequest;
import com.example.corebase.core.admin.developer.service.AdResourceService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/resource")
public class AdResourceController {

    @Autowired
    private AdResourceService service;

    /**
     * Get Page Resource
     * @api /a/resource/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageData(@RequestBody AdResourceFilterRequest req) {
        return new ResponseObject(service.getPageData(req));
    }

    /**
     * Get Detail Resource
     * @api /a/resource/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getDataDetail(@RequestBody Long req) {
        return new ResponseObject(service.getDetailData(req));
    }

    /**
     * Save Resource
     * @api /a/resource/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject saveData(@RequestBody AdResourceRequest req) {
        return new ResponseObject(service.saveData(req));
    }

    /**
     * Remove Detail Resource
     * @api /a/resource/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject removeData(@RequestBody Long req) {
        return new ResponseObject(service.removeData(req));
    }
}
