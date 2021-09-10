package com.ceiba.ConstructoresSAS.infraestructure.configuration;

import com.ceiba.ConstructoresSAS.domain.port.ConstructionRepository;
import com.ceiba.ConstructoresSAS.domain.port.MaterialRepository;
import com.ceiba.ConstructoresSAS.domain.service.RequestConstructionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService {

    @Bean
    public RequestConstructionService requestConstructionService(
            ConstructionRepository constructionRepository, MaterialRepository materialRepository){
        return new RequestConstructionService(constructionRepository, materialRepository);
    }





}
