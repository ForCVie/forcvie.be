package com.example.corebase.core.common.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InitDTO {

    private Long Id;

    private String Name;

    private List<InitDTO> listItem;
}
