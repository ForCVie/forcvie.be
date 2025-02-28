package com.example.corebase.core.admin.promotionMng.controller;

import com.example.corebase.core.admin.promotionMng.model.request.AdBannerFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerReq;
import com.example.corebase.core.admin.promotionMng.service.AdBannerService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/banner-mng")
public class AdBannerController {

    @Autowired
    private AdBannerService service;

    /**
     * Get Page Banner
     * @api /a/banner-mng/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageData(@RequestBody AdBannerFilterReq req) {
        return new ResponseObject(service.getPageData(req));
    }

    /**
     * Get Detail Banner
     * @api /a/banner-mng/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getDataDetail(@RequestBody String req) {
        return new ResponseObject(service.getDataDetail(req));
    }

    /**
     * Save Banner
     * @api /a/banner-mng/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject saveData(@RequestBody AdBannerReq req) {
        return new ResponseObject(service.saveData(req));
    }

    /**
     * Remove Detail Banner
     * @api /a/banner-mng/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject removeData(@RequestBody String req) {
        return new ResponseObject(service.removeData(req));
    }
}
