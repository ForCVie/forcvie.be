package com.example.corebase.core.common.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class FileMngDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fimId;
    private int fimSubFileId;
    private String fimFileCategory;
    private String fimFileName;
    private String fimFilePath;
    private String fimFileExt;
    private long fimFileSize;
    private String fimUseYn;
    private String fimReferKeyId;
    private String fimFileOrgName;
    private String fimSectionName;
    private String deleteFlag;

}
