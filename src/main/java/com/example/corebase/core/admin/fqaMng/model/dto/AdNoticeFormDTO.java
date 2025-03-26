package com.example.corebase.core.admin.fqaMng.model.dto;

import com.example.corebase.core.common.service.dto.CodeMngDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdNoticeFormDTO {

    private List<CodeMngDTO> listRole;
}
