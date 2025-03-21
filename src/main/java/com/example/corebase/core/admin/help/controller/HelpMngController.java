package com.example.corebase.core.admin.help.controller;

import com.example.corebase.core.admin.help.service.HelpMngSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/a/help")
public class HelpMngController {
    @Autowired
    private HelpMngSerivce helpMngService;

    
}
