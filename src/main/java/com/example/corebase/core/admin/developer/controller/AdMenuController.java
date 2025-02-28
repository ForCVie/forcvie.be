package com.example.corebase.core.admin.developer.controller;

import com.example.corebase.core.admin.developer.model.request.AdMenuFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdMenuRequest;
import com.example.corebase.core.admin.developer.service.AdMenuService;
import com.example.corebase.core.base.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/a/developer/menu-mng")
public class AdMenuController {

    @Autowired
    private AdMenuService service;

    /**
     * Get Page Menu
     * @api /a/developer/menu-mng/list
     * @param req
     * @return
     */
    @PostMapping("/list")
    public ResponseObject getPageData(@RequestBody AdMenuFilterRequest req) {
        return new ResponseObject(service.getPageData(req));
    }

    /**
     * Get Detail Menu
     * @api /a/developer/menu-mng/detail
     * @param req
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject getDataDetail(@RequestBody String req) {
        return new ResponseObject(service.getDataDetail(req));
    }

    /**
     * Save Menu
     * @api /a/developer/menu-mng/save
     * @param req
     * @return
     */
    @PostMapping("/save")
    public ResponseObject saveData(@RequestBody AdMenuRequest req) {
        return new ResponseObject(service.saveData(req));
    }

    /**
     * Remove Detail Menu
     * @api /a/developer/menu-mng/remove
     * @param req
     * @return
     */
    @PostMapping("/remove")
    public ResponseObject removeData(@RequestBody String req) {
        return new ResponseObject(service.removeData(req));
    }

    /**
     * Get Data Form Menu
     * @api /a/developer/menu-mng/form
     * @param
     * @return
     */
    @PostMapping("/form")
    public ResponseObject getDataForm(@RequestBody List<String> id) {
        return new ResponseObject(service.getDataForm(id));
    }

}
