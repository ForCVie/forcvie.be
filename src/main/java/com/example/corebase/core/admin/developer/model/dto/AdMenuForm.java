package com.example.corebase.core.admin.developer.model.dto;

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
public class AdMenuForm {

    private List<CodeMngDTO> parentList;
}
