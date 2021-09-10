package com.ceiba.ConstructoresSAS.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ConstructionDto {
    private String constructionType;
    private LocalDate requestDay;
    private String coordinateX;
    private String coordinateY;
    private LocalDate startConstructionDay;
    private LocalDate finishConstructionDay;
    private String state;
}
