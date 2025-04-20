package com.example.corebase.entity.promotional;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Table(name = "popup_notice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PopupNoticeEntity extends AuditEntity implements Serializable {

    @Id
    private String popupNoticeSeq;

    private String title;

    private String url;

    private String useYn;

    private Date startDate;

    private Date endDate;
}
