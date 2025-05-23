package com.example.corebase.core.admin.accountCreation.service.impl;

import com.example.corebase.core.admin.accountCreation.model.dto.AdFoodStoreDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdOwnerDetailDTO;
import com.example.corebase.core.admin.accountCreation.model.dto.AdOwnerResDTO;
import com.example.corebase.core.admin.accountCreation.model.request.AdOwnerFilterRequest;
import com.example.corebase.core.admin.accountCreation.model.request.AdOwnerRequest;
import com.example.corebase.core.admin.accountCreation.repository.AdFoodStoreRepository;
import com.example.corebase.core.admin.accountCreation.repository.AdOwnerRepository;
import com.example.corebase.core.admin.accountCreation.service.AdOwnerService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.auth.OwnerEntity;
import com.example.corebase.entity.orderFood.FoodStrEntity;
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
public class AdOwnerServiceImpl implements AdOwnerService {

    @Autowired
    private AdOwnerRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Autowired
    private AdFoodStoreRepository foodStoreRepository;

    @Override
    public PageableObject<AdOwnerResDTO> getPageData(AdOwnerFilterRequest req) {
        Page<AdOwnerResDTO> dataResult = repository
                .findByUserNameContainsAndDelYn(req.getUserName(), Constants.STATE_N, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdOwnerResDTO.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdOwnerDetailDTO getDataDetail(String id) {
        OwnerEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        AdOwnerDetailDTO response = modelMapper.map(entity, AdOwnerDetailDTO.class);

        List<AdFoodStoreDetailDTO> foodStoreDetails = foodStoreRepository.findByOwnerSeqAndDelYn(id, Constants.STATE_N)
                .stream().map(item -> modelMapper.map(item, AdFoodStoreDetailDTO.class)).toList();

        response.setFoodStores(foodStoreDetails);

        return response;
    }

    @Override
    @Transactional
    public Boolean saveData(AdOwnerRequest req) {
        OwnerEntity entity = modelMapper.map(req, OwnerEntity.class);

        if (StringUtils.isEmpty(entity.getId())) {
            entity.setId(sequencesUtil
                    .generateSequence(SequencesConstant.OWNER_MNG.getPrefix(),
                            SequencesConstant.OWNER_MNG.getTableName()));
            entity.setLockYn(Constants.STATE_N);
            entity.setUserName(CodeGenerator.generateCode(Constants.CODE_OWNER, 10));
        }
        entity.setDelYn(Constants.STATE_N);

        if (req.getFoodStores().isEmpty()) {
            if (StringUtils.isEmpty(req.getId())) {
                List<FoodStrEntity> listDel = foodStoreRepository.findByOwnerSeqAndDelYn(entity.getId(), Constants.STATE_N);
                listDel.forEach(item -> item.setDelYn(Constants.STATE_Y));
                foodStoreRepository.saveAll(listDel);
            }
        } else {
            List<String> listStoreIns = new ArrayList<>();
            List<FoodStrEntity> listStore = req.getFoodStores().stream().map(item -> {
                FoodStrEntity store = modelMapper.map(item, FoodStrEntity.class);

                store.setOwnerSeq(entity.getId());
                store.setDelYn(Constants.STATE_N);
                if (StringUtils.isEmpty(store.getFoodStoreSeq())) {
                    store.setFoodStoreSeq(sequencesUtil
                            .generateSequence(SequencesConstant.FOOD_STORE.getPrefix(),
                                    SequencesConstant.FOOD_STORE.getTableName()));
                    store.setCode(CodeGenerator.generateCode(Constants.FOOD_STORE, 10));
                } else {
                    listStoreIns.add(store.getFoodStoreSeq());
                }

                return store;
            }).toList();

            List<FoodStrEntity> listDelYn = foodStoreRepository.findByDelYnAndOwnerSeqAndFoodStoreSeqNotIn(Constants.STATE_N, entity.getId(), listStoreIns);

            listDelYn.forEach(item -> {
                item.setDelYn(Constants.STATE_Y);
                listStore.add(item);
            });

            foodStoreRepository.saveAll(listStore);
        }

        repository.save(entity);
        return true;
    }

    @Override
    @Transactional
    public Boolean removeData(String id) {
        OwnerEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));
        entity.setDelYn(Constants.STATE_Y);

        List<FoodStrEntity> foodStoreDetails = foodStoreRepository.findByOwnerSeqAndDelYn(id, Constants.STATE_N);
        foodStoreDetails.forEach(item -> item.setDelYn(Constants.STATE_Y));

        repository.save(entity);
        foodStoreRepository.deleteAll(foodStoreDetails);
        return true;
    }
}
