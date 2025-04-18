package com.example.corebase.core.admin.promotionMng.model.request;

import com.example.corebase.core.base.model.PageableRequest;
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
public class AdBannerTeeFilterReq extends PageableRequest {

    private String title;

    private String url;

    private String useYn;

    private Date startDate;

    private Date endDate;
}
