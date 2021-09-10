package com.ceiba.ConstructoresSAS.application.command.handler;

import com.ceiba.ConstructoresSAS.application.command.dtoCommand.ConstructionCommand;
import com.ceiba.ConstructoresSAS.application.command.factory.ConstructionFactory;
import com.ceiba.ConstructoresSAS.domain.model.entity.Construction;
import com.ceiba.ConstructoresSAS.domain.service.RequestConstructionService;

public class CreateConstructionCommandHandler implements AnswerCommandHandler<ConstructionCommand, AnswerCommand<Construction>> {

    private final RequestConstructionService requestConstructionService;

    private final ConstructionFactory constructionFactory;

    public CreateConstructionCommandHandler(RequestConstructionService requestConstructionService, ConstructionFactory constructionFactory) {
        this.requestConstructionService = requestConstructionService;
        this.constructionFactory = constructionFactory;
    }

    public AnswerCommand<Construction> execute(ConstructionCommand constructionCommand){
        Construction construction = constructionFactory.mapToConstruction(constructionCommand);
        return new AnswerCommand<>(this.requestConstructionService.validateAndAssignConstructionRequest(construction));

    }


}
