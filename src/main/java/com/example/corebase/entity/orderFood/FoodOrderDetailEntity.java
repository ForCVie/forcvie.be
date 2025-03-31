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

@Table(name = "food_order_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodOrderDetailEntity extends AuditEntity implements Serializable {

    @Id
    private String foodOrderDetailSeq;

    private String foodOrderSeq;

    private String foodSeq;

    private Long price;

    private Long quantity;
}
