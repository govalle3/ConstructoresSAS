package com.ceiba.ConstructoresSAS.infraestructure.adapters;

import com.ceiba.ConstructoresSAS.infraestructure.adapters.entity.ConstructionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConstructionJpaRepository extends JpaRepository<ConstructionEntity, Long> {



/*    @Query("select i from ConstructionEntity i where i.coordinates = :coordinates")
    Boolean findUsedCoordinates(@Param("coordinates") Point coordinates);*/

/*    @Query("select * from materials")
    List<MaterialsDto> getMaterials();*/



}
