package com.ceiba.ConstructoresSAS.infraestructure.configuration;

import com.ceiba.ConstructoresSAS.application.command.factory.ConstructionFactory;
import com.ceiba.ConstructoresSAS.application.command.handler.CreateConstructionCommandHandler;
import com.ceiba.ConstructoresSAS.application.command.handler.ListConstructionCommandHandler;
import com.ceiba.ConstructoresSAS.domain.port.ConstructionRepository;
import com.ceiba.ConstructoresSAS.domain.service.RequestConstructionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanHandler {

    @Bean
    public ListConstructionCommandHandler listConstructionCommandHandler(
            ConstructionRepository constructionRepository
    ){
        return new ListConstructionCommandHandler(constructionRepository);
    }
    @Bean
    public CreateConstructionCommandHandler createConstructionCommandHandler(
            RequestConstructionService requestConstructionService,
            ConstructionFactory constructionFactory){
        return new CreateConstructionCommandHandler(requestConstructionService,
                constructionFactory);

    }



}
