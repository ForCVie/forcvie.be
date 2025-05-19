package com.example.corebase.core.admin.accountCreation.repository;

import com.example.corebase.entity.orderFood.FoodStrEntity;
import com.example.corebase.repository.orderFood.FoodStrRepository;

import java.util.List;

public interface AdFoodStoreRepository extends FoodStrRepository {

    List<FoodStrEntity> findByOwnerSeqAndDelYn(String ownerSeq, String delYn);

    List<FoodStrEntity> findByDelYnAndOwnerSeqAndFoodStoreSeqNotIn(String delYn, String ownerSeq, List<String> foodStoreSeq);
}
