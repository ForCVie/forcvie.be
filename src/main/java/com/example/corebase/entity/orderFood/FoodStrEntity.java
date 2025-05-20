package com.example.corebase.entity.orderFood;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "food_store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodStrEntity extends AuditEntity implements Serializable {

    @Id
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
