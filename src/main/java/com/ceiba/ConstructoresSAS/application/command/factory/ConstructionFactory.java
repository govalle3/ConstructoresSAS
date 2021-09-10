package com.ceiba.ConstructoresSAS.application.command.factory;

import com.ceiba.ConstructoresSAS.application.command.dtoCommand.ConstructionCommand;
import com.ceiba.ConstructoresSAS.domain.model.entity.Construction;
import org.springframework.stereotype.Component;

@Component
public class ConstructionFactory {

    public Construction mapToConstruction(ConstructionCommand constructionCommand){
        return new Construction(
                constructionCommand.getConstructionType(),
                constructionCommand.getRequestDay(),
                null,
                null,
                constructionCommand.getCoordinateX(),
                constructionCommand.getCoordinateY(),
                null);
    }
}
