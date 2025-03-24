package com.example.corebase.core.common.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FileUploadedInfoDto {

    private String id ;
    private String fimFileName ;
    private String fimFilePath ;
    private int deleteFlag ;
    private String urlFile;
    private Long size;
}
