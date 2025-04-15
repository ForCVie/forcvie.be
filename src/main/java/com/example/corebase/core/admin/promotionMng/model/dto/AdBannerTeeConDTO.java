package com.example.corebase.core.admin.promotionMng.model.dto;

import com.example.corebase.infrastructure.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdBannerTeeConDTO {

    private String delYn = Constants.STATE_N;

    private String actionY = Constants.ACTION_TRUE;

    private String actionN = Constants.ACTION_FALSE;
}
