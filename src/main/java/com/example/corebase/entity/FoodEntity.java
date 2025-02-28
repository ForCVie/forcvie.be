package com.example.corebase.entity;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodEntity extends AuditEntity implements Serializable {

    @Id
    private String foodSeq;

    private String name;

    private String foodCateSeq;

    private String reduceYn;

    private String description;

    private String foodStoreSeq;

    private Long price;

    private Long priceReduce;
}
