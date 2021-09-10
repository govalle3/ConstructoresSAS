package com.ceiba.ConstructoresSAS.infraestructure.adapters;

import com.ceiba.ConstructoresSAS.infraestructure.adapters.entity.ConstructionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ConstructionJpaRepository extends JpaRepository<ConstructionEntity, Long> {

    @Query(value = "SELECT * FROM construction WHERE coordinateX=?1 and coordinateY=?2",
            nativeQuery = true)
    List<ConstructionEntity> findCoordinates(String coordinateX, String coordinateY);

    @Query(value = "SELECT finishConstructionDay FROM construction WHERE state=pendiente",
            nativeQuery = true)
    List<ConstructionEntity> findPendingConstruction();

}
