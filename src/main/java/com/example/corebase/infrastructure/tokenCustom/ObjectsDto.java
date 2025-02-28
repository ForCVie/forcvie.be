package com.example.corebase.infrastructure.tokenCustom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectsDto {

    private String id;

    private String url;

    private String objectType;
}
