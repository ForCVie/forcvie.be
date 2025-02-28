package com.example.corebase.core.common.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeMngDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cdId;

    private String upCdId;

    private String cdNm;
}
