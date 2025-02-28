package com.example.corebase.infrastructure.tokenCustom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PremiumDto {

    private String id;

    private String name;

    private Long startDate;

    private Long endDate;

    private List<ObjectsDto> services;
}
