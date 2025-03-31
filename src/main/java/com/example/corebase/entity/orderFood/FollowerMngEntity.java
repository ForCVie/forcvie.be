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

@Table(name = "follower_mng")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FollowerMngEntity extends AuditEntity implements Serializable {

    @Id
    private String followerMngSeq;

    private String followerUser;

    private String useYn;
}
