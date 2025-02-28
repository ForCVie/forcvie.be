package com.example.corebase.core.admin.developer.service.impl;

import com.example.corebase.core.admin.developer.model.dto.AdRoleDetailDTO;
import com.example.corebase.core.admin.developer.model.dto.AdRoleFormDTO;
import com.example.corebase.core.admin.developer.model.dto.AdRoleResDTO;
import com.example.corebase.core.admin.developer.model.request.AdRoleFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdRoleRequest;
import com.example.corebase.core.admin.developer.repository.AdMenuRepository;
import com.example.corebase.core.admin.developer.repository.AdMenuRoleRepository;
import com.example.corebase.core.admin.developer.repository.AdRoleRepository;
import com.example.corebase.core.admin.developer.service.AdRoleService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.common.service.dto.CodeMngDTO;
import com.example.corebase.entity.system.SysMenuRoleEntity;
import com.example.corebase.entity.system.SysRoleEntity;
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
public class AdRoleServiceImpl implements AdRoleService {

    @Autowired
    private AdRoleRepository repository;

    @Autowired
    private AdMenuRoleRepository menuRoleRepository;

    @Autowired
    private AdMenuRepository menuRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Override
    public PageableObject<AdRoleResDTO> getPageData(AdRoleFilterRequest req) {
        Page<AdRoleResDTO> dataResult = repository
                .findByRoleCdContainsAndRoleNmContainsAndRoleSiteCdContains
                        (req.getRoleCd(), req.getRoleNm(), req.getRoleSiteCd(), PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdRoleResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdRoleDetailDTO getDataDetail(String id) {
        SysRoleEntity roleEntity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        AdRoleDetailDTO roleResponse = modelMapper.map(roleEntity, AdRoleDetailDTO.class);

        List<String> menuRoleEntities = menuRoleRepository.findByRoleId(id)
                .stream().map(SysMenuRoleEntity::getMenuId).toList();
        roleResponse.setListMenu(menuRoleEntities);

        return roleResponse;
    }

    @Override
    @Transactional
    public Boolean saveData(AdRoleRequest req) {
        SysRoleEntity roleEntity = modelMapper.map(req, SysRoleEntity.class);

        if (StringUtils.isEmpty(roleEntity.getRoleId())) {
            roleEntity.setRoleId(sequencesUtil
                    .generateSequence(SequencesConstant.SYS_ROLE_MNG.getPrefix(),
                            SequencesConstant.SYS_ROLE_MNG.getTableName()));
        }
        List<SysMenuRoleEntity> menuRoleEntities = menuRoleRepository.findByRoleId(roleEntity.getRoleId());

        List<SysMenuRoleEntity> menuRoleSave = req.getListMenu().stream().map(item -> {
            SysMenuRoleEntity menuRoleEntity = menuRoleEntities.stream()
                    .filter(menuRole -> menuRole.getMenuId().equals(item))
                    .findFirst()
                    .orElseGet(() -> {
                        SysMenuRoleEntity newMenuRole = new SysMenuRoleEntity();
                        newMenuRole.setMenuRoleSeq(sequencesUtil.generateSequence(
                                SequencesConstant.MENU_ROLE.getPrefix(),
                                SequencesConstant.MENU_ROLE.getTableName()));
                        return newMenuRole;
                    });

            menuRoleEntity.setRoleId(roleEntity.getRoleId());
            menuRoleEntity.setMenuId(item);
            return menuRoleEntity;
        }).toList();

        List<SysMenuRoleEntity> listDelete = menuRoleEntities.stream()
                .filter(itemDel -> menuRoleSave.stream()
                        .noneMatch(itemSave -> itemSave.getMenuRoleSeq().equals(itemDel.getMenuRoleSeq())))
                .toList();

        repository.save(roleEntity);
        menuRoleRepository.saveAll(menuRoleSave);
        menuRoleRepository.deleteAll(listDelete);

        return true;
    }

    @Override
    @Transactional
    public Boolean removeData(String id) {
        repository.deleteById(id);

        List<SysMenuRoleEntity> menuRoleEntities = menuRoleRepository.findByRoleId(id);
        menuRoleRepository.deleteAll(menuRoleEntities);
        return null;
    }

    @Override
    public AdRoleFormDTO getFormData(String siteCd) {
        AdRoleFormDTO dataResult = new AdRoleFormDTO();

        List<CodeMngDTO> menuParent = menuRepository.findByDelYnAndSiteType(Constants.STATE_N, siteCd)
                .stream().map(item -> new CodeMngDTO(item.getMenuId(), item.getParentId(), item.getNm())).toList();

        dataResult.setListMenu(menuParent);
        return dataResult;
    }
}
