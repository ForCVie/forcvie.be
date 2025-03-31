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
import java.time.LocalDateTime;

@Table(name = "voucher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VoucherEntity extends AuditEntity implements Serializable {

    @Id
    private String voucherSeq;

    private String typeCd;

    private String foodStoreSeq;

    private Long quantity;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String useYn;

    private String usePolicy;

    private String statusAppr;

    private LocalDateTime apprDate;

    private String apprUser;

    private Long value;
}
