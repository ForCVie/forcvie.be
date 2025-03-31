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

@Table(name = "food_cate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodCateEntity extends AuditEntity implements Serializable {

    @Id
    private String foodCateSeq;

    private String name;

    private String foodStoreSeq;
}
