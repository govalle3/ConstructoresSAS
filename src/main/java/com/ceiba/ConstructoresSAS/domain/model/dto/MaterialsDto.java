package com.ceiba.ConstructoresSAS.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class MaterialsDto {

    private  Long    id;
    private  Integer concrete;
    private  Integer gravel;
    private  Integer sand;
    private  Integer wood;
    private  Integer adobe;



}
