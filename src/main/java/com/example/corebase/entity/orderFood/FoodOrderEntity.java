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

@Table(name = "food_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodOrderEntity extends AuditEntity implements Serializable {

    @Id
    private String foodOrderSeq;

    private String foodStoreSeq;

    private String code;

    private String status;

    private String receiverNm;

    private String receiverPhone;

    private String receiverAddress;

    private Long priceTotal;

    private String description;
}
