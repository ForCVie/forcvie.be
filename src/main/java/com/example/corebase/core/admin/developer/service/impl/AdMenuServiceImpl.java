package com.example.corebase.core.admin.developer.service.impl;

import com.example.corebase.core.admin.developer.model.dto.AdMenuConDTO;
import com.example.corebase.core.admin.developer.model.dto.AdMenuDetailDTO;
import com.example.corebase.core.admin.developer.model.dto.AdMenuForm;
import com.example.corebase.core.admin.developer.model.dto.AdMenuResDTO;
import com.example.corebase.core.admin.developer.model.request.AdMenuFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdMenuRequest;
import com.example.corebase.core.admin.developer.repository.AdMenuRepository;
import com.example.corebase.core.admin.developer.service.AdMenuService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.common.service.dto.CodeMngDTO;
import com.example.corebase.entity.system.SysMenuEntity;
import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.infrastructure.constant.SequencesConstant;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.pageCommon.PageableCommon;
import com.example.corebase.util.sequenceCommon.SequencesUtil;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdMenuServiceImpl implements AdMenuService {

    @Autowired
    private AdMenuRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Override
    public PageableObject<AdMenuResDTO> getPageData(AdMenuFilterRequest req) {
        Page<AdMenuResDTO> dataResult = repository
                .getPageData(req, new AdMenuConDTO(), PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdMenuResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdMenuDetailDTO getDataDetail(String id) {
        SysMenuEntity menuEntity = repository.findByMenuIdAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(menuEntity, AdMenuDetailDTO.class);
    }

    @Override
    @Transactional
    public Boolean saveData(AdMenuRequest req) {
        SysMenuEntity menuEntity = modelMapper.map(req, SysMenuEntity.class);

        if (StringUtils.isEmpty(menuEntity.getMenuId())) {
            menuEntity.setMenuId(sequencesUtil
                    .generateSequence(SequencesConstant.CPS_MENU_MNG.getPrefix(),
                            SequencesConstant.CPS_MENU_MNG.getTableName()));
        }

        repository.save(menuEntity);
        return true;
    }

    @Override
    @Transactional
    public Boolean removeData(String id) {
        SysMenuEntity menuEntity = repository.findByMenuIdAndDelYn(id, Constants.STATE_N)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));
        menuEntity.setDelYn(Constants.STATE_Y);

        repository.save(menuEntity);
        return true;
    }

    @Override
    public AdMenuForm getDataForm(List<String> id) {
        AdMenuForm dataResult = new AdMenuForm();

        List<CodeMngDTO> menuParent = repository.findByMenuIdNotInAndDelYn(id, Constants.STATE_N)
                .stream().map(item -> new CodeMngDTO(item.getMenuId(), "", item.getNm())).toList();
        dataResult.setParentList(menuParent);

        return dataResult;
    }
}
