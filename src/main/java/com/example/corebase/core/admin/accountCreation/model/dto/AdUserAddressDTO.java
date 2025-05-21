package com.example.corebase.core.admin.accountCreation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdUserAddressDTO {

    private String userAddressSeq;

    private String content;

    private String isDefault;

    private String userId;
}
