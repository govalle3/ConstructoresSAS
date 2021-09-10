package com.ceiba.ConstructoresSAS.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;

@Getter
@Setter
public class Construction {
    private static final String MESSAGE_TYPE_OF_CONSTRUCTION_REQUIRED = "Se debe ingresar el tipo de construcción";
    private static final String MESSAGE_COORDINATES_REQUIRED = "Se deben ingresar coordenadas";


    private String constructionType;
    private LocalDate requestDay;
    private LocalDate startConstructionDay;
    private LocalDate finishConstructionDay;
    private String coordinateX;
    private String coordinateY;
    private String state;

    public Construction(String constructionType, LocalDate requestDay,
                        LocalDate startConstructionDay, LocalDate finishConstructionDay,
                        String coordinateX, String coordinateY, String state) {
        this.constructionType = constructionType;
        this.requestDay = requestDay;
        this.startConstructionDay = startConstructionDay;
        this.finishConstructionDay = finishConstructionDay;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.state = state;
    }


}
