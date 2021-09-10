package com.ceiba.ConstructoresSAS.infraestructure.adapters;

import com.ceiba.ConstructoresSAS.infraestructure.adapters.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialJpaRepository  extends JpaRepository<MaterialEntity, Long> {

}
