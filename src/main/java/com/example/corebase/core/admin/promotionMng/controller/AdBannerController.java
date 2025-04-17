package com.example.corebase.core.admin.promotionMng.controller;

import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerReq;
import com.example.corebase.core.admin.promotionMng.service.AdBannerService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/promotion/banner-mng")
public class AdBannerController {

    @Autowired
    private AdBannerService service;

    /**
     * Get Page Banner
     * @api /a/promotion/banner-mng/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject<PageableObject<AdBannerResDTO>> getPageData(@RequestBody AdBannerFilterReq req) {
        return new ResponseObject<PageableObject<AdBannerResDTO>>(service.getPageData(req));
    }

    /**
     * Get Detail Banner
     * @api /a/promotion/banner-mng/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject<AdBannerDetailDTO> getDataDetail(@RequestBody String req) {
        return new ResponseObject<AdBannerDetailDTO>(service.getDataDetail(req));
    }

    /**
     * Save Banner
     * @api /a/promotion/banner-mng/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject<Boolean> saveData(@RequestBody AdBannerReq req) {
        return new ResponseObject<Boolean>(service.saveData(req));
    }

    /**
     * Remove Detail Banner
     * @api /a/promotion/banner-mng/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject<Boolean> removeData(@RequestBody String req) {
        return new ResponseObject<Boolean>(service.removeData(req));
    }
}
