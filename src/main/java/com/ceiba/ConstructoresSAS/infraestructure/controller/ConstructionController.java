package com.ceiba.ConstructoresSAS.infraestructure.controller;


import com.ceiba.ConstructoresSAS.application.command.dtoCommand.ConstructionCommand;
import com.ceiba.ConstructoresSAS.application.command.handler.AnswerCommand;
import com.ceiba.ConstructoresSAS.application.command.handler.CreateConstructionCommandHandler;
import com.ceiba.ConstructoresSAS.application.command.handler.ListConstructionCommandHandler;
import com.ceiba.ConstructoresSAS.domain.model.dto.ConstructionDto;
import com.ceiba.ConstructoresSAS.domain.model.entity.Construction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RestController
@RequestMapping(value ="/construction")
public class ConstructionController {

    private final CreateConstructionCommandHandler createConstructionCommandHandler;
    private final ListConstructionCommandHandler listConstructionCommandHandler;

    @Autowired
    public ConstructionController(CreateConstructionCommandHandler createConstructionCommandHandler,
                                  ListConstructionCommandHandler listConstructionCommandHandler) {
        this.createConstructionCommandHandler = createConstructionCommandHandler;
        this.listConstructionCommandHandler = listConstructionCommandHandler;
    }

    @PostMapping(path = "/architect")
    public AnswerCommand<Construction> scheduleConstruction(@RequestBody ConstructionCommand constructionCommand){
        return createConstructionCommandHandler.execute(constructionCommand);
    }

    @GetMapping(path = "/list")
    public List<ConstructionDto> findEndDateConstruction(){
        return this.listConstructionCommandHandler.execute();
    }

}
