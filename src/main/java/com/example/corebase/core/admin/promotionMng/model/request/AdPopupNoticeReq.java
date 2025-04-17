package com.example.corebase.core.admin.promotionMng.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdPopupNoticeReq {

    private String popupNoticeSeq;

    private String title;

    private String url;

    private String useYn;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
