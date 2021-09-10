package com.ceiba.ConstructoresSAS.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class MaterialsDto {
    private final Integer concrete;
    private final Integer gravel;
    private final Integer sand;
    private final Integer wood;
    private final Integer adobe;


}
