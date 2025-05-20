package com.example.corebase.core.admin.accountCreation.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdFoodStoreRequest {

    private String foodStoreSeq;

    private String code;

    private String nm;

    private String ownerSeq;

    private String address;

    private String phoneOwner;

    private String phoneSp;

    private String isShowPhoneOwner;

    private String isBadge;

    private String avatar;

    private String isActivity;
}
