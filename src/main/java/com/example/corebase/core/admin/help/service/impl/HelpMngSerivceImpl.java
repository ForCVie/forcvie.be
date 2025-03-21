package com.example.corebase.core.admin.help.service.impl;

import com.example.corebase.core.admin.help.repository.HelpMngRepository;
import com.example.corebase.core.admin.help.service.HelpMngSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpMngSerivceImpl implements HelpMngSerivce {
    @Autowired
    private HelpMngRepository helpMngRepository;


}
