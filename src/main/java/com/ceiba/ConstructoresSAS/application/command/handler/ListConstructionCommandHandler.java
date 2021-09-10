package com.ceiba.ConstructoresSAS.application.command.handler;

import com.ceiba.ConstructoresSAS.domain.model.dto.ConstructionDto;
import com.ceiba.ConstructoresSAS.domain.port.ConstructionRepository;

import java.util.List;

public class ListConstructionCommandHandler {

    private ConstructionRepository constructionRepository;

    public ListConstructionCommandHandler(ConstructionRepository constructionRepository) {
        this.constructionRepository = constructionRepository;
    }

    public List<ConstructionDto> execute(){
        return this.constructionRepository.findEndDateConstruction();
    }
}
