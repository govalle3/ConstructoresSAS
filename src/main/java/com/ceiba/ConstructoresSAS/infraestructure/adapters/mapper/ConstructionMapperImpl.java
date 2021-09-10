package com.ceiba.ConstructoresSAS.infraestructure.adapters.mapper;

import com.ceiba.ConstructoresSAS.domain.model.dto.ConstructionDto;
import com.ceiba.ConstructoresSAS.domain.model.entity.Construction;
import com.ceiba.ConstructoresSAS.infraestructure.adapters.entity.ConstructionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConstructionMapperImpl {

    public ConstructionEntity mapToEntity(Construction construction){
        ConstructionEntity constructionEntity = new ConstructionEntity();
        constructionEntity.setConstructionType(construction.getConstructionType());
        constructionEntity.setRequestDay(construction.getRequestDay());
        constructionEntity.setStartConstructionDay(construction.getStartConstructionDay());
        constructionEntity.setFinishConstructionDay(construction.getFinishConstructionDay());
        constructionEntity.setCoordinateX(construction.getCoordinateX());
        constructionEntity.setCoordinateY(construction.getCoordinateY());
        constructionEntity.setState(construction.getState());
        return constructionEntity;
    }

    public Construction mapFromEntity(ConstructionEntity constructionEntity){
        return new Construction(
                constructionEntity.getConstructionType(),
                constructionEntity.getRequestDay(),
                constructionEntity.getStartConstructionDay(),
                constructionEntity.getFinishConstructionDay(),
                constructionEntity.getCoordinateX(),
                constructionEntity.getCoordinateY(),
                constructionEntity.getState()
        );
    }

    public List<ConstructionDto> mapFromEntityList(Iterable<ConstructionEntity> listEntity){
        List<ConstructionDto> constructionDtoList = new ArrayList<>();
        listEntity.forEach(constructionEntity -> {
            ConstructionDto constructionDto = new ConstructionDto(
                    constructionEntity.getConstructionType(),
                    constructionEntity.getRequestDay(),
                    constructionEntity.getCoordinateX(),
                    constructionEntity.getCoordinateY(),
                    constructionEntity.getStartConstructionDay(),
                    constructionEntity.getFinishConstructionDay(),
                    constructionEntity.getState()
            );
            constructionDtoList.add(constructionDto);
        });
        return constructionDtoList;
    }
}
