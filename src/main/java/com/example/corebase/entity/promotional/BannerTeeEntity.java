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

@Table(name = "banner_tee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BannerTeeEntity extends AuditEntity implements Serializable {

    @Id
    private String bannerTeeSeq;

    private String title;

    private String url;

    private String content;

    private String useYn;

    private Date startDate;

    private Date endDate;
}
