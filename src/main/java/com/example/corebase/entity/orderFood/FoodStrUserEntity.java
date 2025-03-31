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

@Table(name = "food_store_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodStrUserEntity extends AuditEntity implements Serializable {

    @Id
    private String foodStoreUserSeq;

    private String foodStoreSeq;

    private String userId;

    private String positionSeq;
}
