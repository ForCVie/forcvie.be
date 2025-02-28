package com.example.corebase.core.base.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.infrastructure.constant.LanguageConstants;
import com.example.corebase.util.languageCommon.LanguageCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/base")
public class BaseMessageController {

    @Autowired
    private LanguageCommon languageCommon;

    @GetMapping
    public ResponseObject getProperties(String key) {
        return new ResponseObject(languageCommon.getMessageProperties(key));
    }

    @GetMapping("/change-en")
    public ResponseObject getChangeLanguageEn() {
        return new ResponseObject(languageCommon.changeLanguageCommon(LanguageConstants.LANGUAGE_ENGLISH));
    }

    @GetMapping("/change-vn")
    public ResponseObject getChangeLanguageVn() {
        return new ResponseObject(languageCommon.changeLanguageCommon(LanguageConstants.LANGUAGE_VIETNAMESE));
    }
}
