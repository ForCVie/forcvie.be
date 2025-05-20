package com.example.corebase.core.admin.storeManager.controller;

import com.example.corebase.core.admin.storeManager.service.AdStoreManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a/store-manager/store")
public class AdStoreManagerController {

    @Autowired
    private AdStoreManagerService service;
}
