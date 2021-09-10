package com.ceiba.ConstructoresSAS.domain.model.entity;

import com.ceiba.ConstructoresSAS.domain.exception.ExceptionConstruction;
import com.ceiba.ConstructoresSAS.domain.exception.ExceptionCoordinates;

import java.awt.*;

public class ArgumentValidator {

    public static void validateRequired(String value, String message){
        if(value == null || value.isEmpty()){
            throw new ExceptionConstruction(message);
        }
    }

    public static void validateCoordinates(Point coordinate, String message){
        if(coordinate == null){
            throw new ExceptionCoordinates(message);
        }
    }
}
