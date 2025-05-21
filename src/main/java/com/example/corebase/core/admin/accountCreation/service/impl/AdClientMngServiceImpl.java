package com.example.corebase.core.admin.accountCreation.service.impl;

import com.example.corebase.core.admin.accountCreation.model.dto.AdClientDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdClientResDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdUserAddressDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdClientFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdClientMngRequest;
import com.example.corebase.core.admin.accountCreation.repository.AdClientMngRepository;
import com.example.corebase.core.admin.accountCreation.repository.AdUserAddressRepository;
import com.example.corebase.core.admin.accountCreation.service.AdClientMngService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.auth.UserAddressEntity;
import com.example.corebase.entity.auth.UserEntity;
import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.infrastructure.constant.SequencesConstant;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.codeGenerator.CodeGenerator;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.pageCommon.PageableCommon;
import com.example.corebase.util.sequenceCommon.SequencesUtil;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdClientMngServiceImpl implements AdClientMngService {

    @Autowired
    private AdClientMngRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Autowired
    private AdUserAddressRepository addressRepository;

    @Override
    public PageableObject<AdClientResDTO> getPageData(AdClientFilterRequest req) {
        Page<AdClientResDTO> dataResult = repository
                .findByUserNameContainsAndFullNameContainsAndDelYn(req.getUserName(), req.getFullName(), Constants.STATE_N, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdClientResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdClientDetailDTO getDataDetail(String id) {
        UserEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        AdClientDetailDTO result = modelMapper.map(entity, AdClientDetailDTO.class);
        List<AdUserAddressDTO> listAddress = addressRepository.findAddressByUser(id, Constants.STATE_N).stream().map(item -> modelMapper.map(item, AdUserAddressDTO.class)).toList();

        result.setListAddress(listAddress);

        return result;
    }

    @Override
    @Transactional
    public Boolean saveData(AdClientMngRequest req) {
        UserEntity userEntity = modelMapper.map(req, UserEntity.class);

        if (StringUtils.isEmpty(userEntity.getId())) {
            userEntity.setId(sequencesUtil
                    .generateSequence(SequencesConstant.USER_MNG.getPrefix(),
                            SequencesConstant.USER_MNG.getTableName()));
            userEntity.setUserName(CodeGenerator.generateCode(Constants.CODE_CLIENT, 10));
            userEntity.setLockYn(Constants.STATE_N);
        }
        userEntity.setDelYn(Constants.STATE_N);

        List<String> listStoreIns = new ArrayList<>();

        if (req.getListAddress().isEmpty()) {
            if (StringUtils.isEmpty(req.getId())) {
                List<UserAddressEntity> listDel = addressRepository.findAddressByUser(req.getId(), Constants.STATE_N).stream().map(item -> modelMapper.map(item, UserAddressEntity.class)).toList();
                listDel.forEach(item -> item.setDelYn(Constants.STATE_N));
                addressRepository.saveAll(listDel);
            }
        } else {
            List<UserAddressEntity> listAddress = req.getListAddress().stream().map(item -> {
                UserAddressEntity address = modelMapper.map(item, UserAddressEntity.class);
                address.setUserId(userEntity.getId());

                if (StringUtils.isEmpty(req.getId())) {
                    address.setUserAddressSeq(sequencesUtil.generateSequence(SequencesConstant.USER_ADDRESS_MNG.getPrefix(), SequencesConstant.USER_ADDRESS_MNG.getTableName()));
                } else {
                    listStoreIns.add(address.getUserAddressSeq());
                }

                return address;
            }).toList();

            List<UserAddressEntity> listDelYn = addressRepository.findByDelYnAndUserIdAndUserAddressSeqNotIn(Constants.STATE_N, req.getId(), listStoreIns);

            listDelYn.forEach(item -> {
                item.setDelYn(Constants.STATE_Y);
                listAddress.add(item);
            });

            addressRepository.saveAll(listAddress);
        }

        repository.save(userEntity);
        return true;
    }

    @Override
    @Transactional
    public Boolean removeData(String id) {
        UserEntity userEntity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        userEntity.setDelYn(Constants.STATE_Y);

        repository.save(userEntity);
        return true;
    }
}
