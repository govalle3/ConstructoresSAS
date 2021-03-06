package com.ceiba.ConstructoresSAS.infraestructure.adapters.repository;

import com.ceiba.ConstructoresSAS.domain.model.dto.ConstructionDto;
import com.ceiba.ConstructoresSAS.domain.model.entity.Construction;
import com.ceiba.ConstructoresSAS.domain.port.ConstructionRepository;
import com.ceiba.ConstructoresSAS.infraestructure.adapters.ConstructionJpaRepository;
import com.ceiba.ConstructoresSAS.infraestructure.adapters.entity.ConstructionEntity;
import com.ceiba.ConstructoresSAS.infraestructure.adapters.mapper.ConstructionMapperImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConstructionRepositoryImpl implements ConstructionRepository {

    private final ConstructionJpaRepository constructionJpaRepository;
    private final ConstructionMapperImpl constructionMapper;

    public ConstructionRepositoryImpl(ConstructionJpaRepository constructionJpaRepository, ConstructionMapperImpl constructionMapper) {
        this.constructionJpaRepository = constructionJpaRepository;
        this.constructionMapper = constructionMapper;
    }

    @Override
    public Construction saveConstructionRequest(Construction construction) {
        ConstructionEntity constructionEntity = constructionMapper.mapToEntity(construction);
        Construction construction1 = constructionMapper.mapFromEntity(constructionEntity);
        this.constructionJpaRepository.save(constructionEntity);
        return construction1;
    }

    @Override
    public List<ConstructionDto> findConstruction() {
        return this.constructionMapper.mapFromEntityList(this.constructionJpaRepository.findAll());
    }

    @Override
    public Boolean validateCoordinate(String coordinateX, String coordinateY) {
        if(this.constructionJpaRepository.findCoordinates(coordinateX, coordinateY).size() > 0){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<ConstructionDto> findPendingConstruction() {
        return this.constructionMapper.mapFromEntityList(this.constructionJpaRepository.findPendingConstruction());
    }

}
