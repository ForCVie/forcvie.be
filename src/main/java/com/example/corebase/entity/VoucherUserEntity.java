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

@Table(name = "voucher_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VoucherUserEntity extends AuditEntity implements Serializable {

    @Id
    private String voucherUserSeq;

    private String userId;

    private String voucherSeq;
}
