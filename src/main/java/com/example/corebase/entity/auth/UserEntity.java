package com.example.corebase.entity.auth;

import com.example.corebase.entity.base.AuditEntity;
import com.example.corebase.entity.base.PrimaryBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "USER_MNG")
public class UserEntity extends AuditEntity {

    @Id
    private String id;

    private String userName;

    private String password;

    private String fullName;

    private String date;

    private String phone;

    private String email;

    private String address;

    private String nationality;

    private String avatar;

    private String lockYn;
}
