package com.example.corebase.core.admin.promotionMng.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdBannerTeeDetailDTO {

    private String bannerTeeSeq;

    private String title;

    private String url;

    private String content;

    private String useYn;

    private Date startDate;

    private Date endDate;
}
