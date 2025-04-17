package com.example.corebase.core.admin.promotionMng.controller;

import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeDetailDTO;
import com.example.corebase.core.admin.promotionMng.model.dto.AdPopupNoticeResDTO;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdBannerReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdPopupNoticeFilterReq;
import com.example.corebase.core.admin.promotionMng.model.request.AdPopupNoticeReq;
import com.example.corebase.core.admin.promotionMng.service.AdPopupNoticeService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/promotion/popup-notice")
public class AdPopupNoticeController {

    @Autowired
    private AdPopupNoticeService service;

    /**
     * Get Page Banner
     * @api /a/promotion/popup-notice/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject<PageableObject<AdPopupNoticeResDTO>> getPageData(@RequestBody AdPopupNoticeFilterReq req) {
        return new ResponseObject<PageableObject<AdPopupNoticeResDTO>>(service.getPageData(req));
    }

    /**
     * Get Detail Banner
     * @api /a/promotion/popup-notice/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject<AdPopupNoticeDetailDTO> getDataDetail(@RequestBody String req) {
        return new ResponseObject<AdPopupNoticeDetailDTO>(service.getDataDetail(req));
    }

    /**
     * Save Banner
     * @api /a/promotion/popup-notice/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject<Boolean> saveData(@RequestBody AdPopupNoticeReq req) {
        return new ResponseObject<Boolean>(service.saveData(req));
    }

    /**
     * Remove Detail Banner
     * @api /a/promotion/popup-notice/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject<Boolean> removeData(@RequestBody String req) {
        return new ResponseObject<Boolean>(service.removeData(req));
    }
}
