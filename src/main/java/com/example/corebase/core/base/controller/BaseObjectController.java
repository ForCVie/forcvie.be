package com.example.corebase.core.base.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cmmn/menu")
public class BaseObjectController {

    @Autowired
    private BaseService baseMessageService;

    @GetMapping("/nav-tree")
    public ResponseObject getAllObjectByUser() {
        return new ResponseObject(baseMessageService.getListObjectByUser());
    }
}
