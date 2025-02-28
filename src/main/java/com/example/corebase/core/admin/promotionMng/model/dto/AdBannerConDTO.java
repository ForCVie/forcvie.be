package com.example.corebase.core.admin.promotionMng.model.dto;

import com.example.corebase.infrastructure.constant.Constants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdBannerConDTO {

    private String delYn = Constants.STATE_N;

    private String typeCd = Constants.BANNER_TYPE_HOME;
}
