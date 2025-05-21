package com.example.corebase.core.admin.accountCreation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdOwnerDetailDTO {

    private String id;

    private String userName;

    private String password;

    private String fullName;

    private String date;

    private String phone;

    private String email;

    private String address;

    private String nationality;

    private String avatar;

    private String lockYn;

    private List<AdFoodStoreDetailDTO> foodStores;
}
