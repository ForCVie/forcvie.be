package com.example.corebase.core.admin.fqaMng.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdNoticeResDTO {

    private String noticeSeq;

    private String title;

    private String postCd;

    private String topFixCd;

    private String roleId;
}
