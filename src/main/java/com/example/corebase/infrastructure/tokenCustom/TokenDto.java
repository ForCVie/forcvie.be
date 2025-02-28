package com.example.corebase.infrastructure.tokenCustom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {

    private String idUser;

    private String username;

    private String fullName;

//    private RolesEntity roleCode;

    private String module;

    // if role is UsersEntity
    private PremiumDto premium;

    // if role is StaffEntity
    private ObjectsDto service;

//    public TokenDto(UsersEntity entity, PremiumDto premium) {
//        this.idUser = entity.getId();
//        this.roleCode = entity.getRoleId();
//        this.username = entity.getUserName();
//        this.fullName = entity.getFullName();
//        this.module = KeyModule.MODULE_CLIENT;
//        this.premium = premium;
//    }
//
//    public TokenDto(StaffEntity entity, ObjectsDto service) {
//        this.idUser = entity.getId();
//        this.roleCode = entity.getRoleId();
//        this.username = entity.getUsername();
//        this.fullName = entity.getFullName();
//        this.module = KeyModule.MODULE_STAFF;
//        this.service = service;
//    }
}
