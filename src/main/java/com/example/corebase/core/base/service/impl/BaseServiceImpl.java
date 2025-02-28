package com.example.corebase.core.base.service.impl;

import com.example.corebase.core.base.model.AuthLoginService;
import com.example.corebase.core.base.model.MenuResDTO;
import com.example.corebase.core.base.service.BaseService;
import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.repository.system.SysMenuRepository;
import com.example.corebase.util.languageCommon.LanguageCommon;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {

    @Qualifier("sysMenuRepository")
    @Autowired
    private SysMenuRepository repository;

    @Autowired
    private AuthLoginService authLoginService;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MenuResDTO> getListObjectByUser() {
//        List<ObjectsEntity> list = objectsRepository.getObjectsByIdUsers(authLoginService.getAuth().getId());
//        List<ObjectsEntity> list = objectsRepository.getObjectsByIdUsers(1L);
//        List<ObjectDto> response = list.stream().map(el ->
//                new ObjectDto(languageCommon.getMessageProperties(el.getKey()), el.getIcons(), el.getUrl()))
//        .collect(Collectors.toList());
        List<MenuResDTO> listResponse = repository
                .findByDelYnAndSiteTypeOrderByDisplayOrder(Constants.STATE_N, Constants.ROLE_ADMIN)
                .stream().map((item) -> modelMapper.map(item, MenuResDTO.class)).toList();
        return listResponse;
    }
}
