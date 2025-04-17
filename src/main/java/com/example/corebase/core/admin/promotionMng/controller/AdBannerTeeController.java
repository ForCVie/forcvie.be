package com.example.corebase.core.admin.promotionMng.controller;

import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdBannerTeeResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerTeeFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerTeeReq;
import com.example.corebase.core.admin.promotionMng.service.AdBannerTeeService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/promotion/banner-tee")
public class AdBannerTeeController {

    @Autowired
    private AdBannerTeeService service;

    /**
     * Get Page Banner
     * @api /a/promotion/banner-tee/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject<PageableObject<AdBannerTeeResDTO>> getPageData(@RequestBody AdBannerTeeFilterReq req) {
        return new ResponseObject<PageableObject<AdBannerTeeResDTO>>(service.getPageData(req));
    }

    /**
     * Get Detail Banner
     * @api /a/promotion/banner-tee/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject<AdBannerTeeDetailDTO> getDataDetail(@RequestBody String req) {
        return new ResponseObject<AdBannerTeeDetailDTO>(service.getDataDetail(req));
    }

    /**
     * Save Banner
     * @api /a/promotion/banner-tee/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject<Boolean> saveData(@RequestBody AdBannerTeeReq req) {
        return new ResponseObject<Boolean>(service.saveData(req));
    }

    /**
     * Remove Detail Banner
     * @api /a/promotion/banner-tee/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject<Boolean> removeData(@RequestBody String req) {
        return new ResponseObject<Boolean>(service.removeData(req));
    }
}
