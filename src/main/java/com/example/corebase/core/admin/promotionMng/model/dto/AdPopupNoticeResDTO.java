package com.example.corebase.core.admin.promotionMng.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdPopupNoticeResDTO {

    private String popupNoticeSeq;

    private String title;

    private String url;

    private String useYn;

    private String startDate;

    private String endDate;
}
