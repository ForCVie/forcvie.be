package com.example.corebase.entity.fqa;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notice")
@Entity
public class NoticeEntity extends AuditEntity implements Serializable {

    @Id
    private String noticeSeq;

    private String title;

    private String content;

    private String postCd;

    private String topFixCd;

    private Integer readCnt;

    private String roleId;
}
