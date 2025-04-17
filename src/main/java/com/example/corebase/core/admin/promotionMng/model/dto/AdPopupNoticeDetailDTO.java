package com.example.corebase.core.admin.promotionMng.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdPopupNoticeDetailDTO {

    private String popupNoticeSeq;

    private String title;

    private String url;

    private String useYn;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
