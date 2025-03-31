package com.example.corebase.entity.common;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "notification_mng")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NotificationMngEntity extends AuditEntity implements Serializable {

    @Id
    private String notificationSeq;

    private String title;

    private String userSendSeq;

    private String isRead;

    private String userReadSeq;

    private String content;

    private String url;

    private String typeCd;
}
