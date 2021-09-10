package com.ceiba.ConstructoresSAS.infraestructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.ceiba.ConstructoresSAS.infraestructure.adapters.entity"})
@EnableJpaRepositories(basePackages = {"com.ceiba.ConstructoresSAS.infraestructure.adapters"})
@Configuration
public class JpaConfig {

}
