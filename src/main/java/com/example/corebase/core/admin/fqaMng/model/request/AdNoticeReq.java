package com.example.corebase.core.admin.fqaMng.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdNoticeReq {

    private String noticeSeq;

    private String title;

    private String content;

    private String postCd;

    private String topFixCd;

    private Integer readCnt;

    private String roleId;
}
