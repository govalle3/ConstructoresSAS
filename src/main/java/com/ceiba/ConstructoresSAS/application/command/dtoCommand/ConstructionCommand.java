package com.ceiba.ConstructoresSAS.application.command.dtoCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ConstructionCommand {

    private String constructionType;
    private LocalDate requestDay;
    private String coordinateX;
    private String coordinateY;

}
