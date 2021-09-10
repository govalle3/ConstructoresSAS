package com.ceiba.ConstructoresSAS.infraestructure.adapters.mapper;

import com.ceiba.ConstructoresSAS.domain.model.dto.MaterialsDto;
import com.ceiba.ConstructoresSAS.domain.model.entity.Construction;
import com.ceiba.ConstructoresSAS.infraestructure.adapters.entity.ConstructionEntity;
import com.ceiba.ConstructoresSAS.infraestructure.adapters.entity.MaterialEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MaterialMapper {

    public final Function<MaterialEntity, MaterialsDto> mapToDto =
            materialEntity -> new MaterialsDto(
                    materialEntity.getId(),
                    materialEntity.getConcrete(),
                    materialEntity.getGravel(),
                    materialEntity.getSand(),
                    materialEntity.getWood(),
                    materialEntity.getAdobe());

/*    public final Function<MaterialsDto, MaterialEntity > mapToEntity =
            materialsDto -> new MaterialEntity(
                    materialsDto.getConcrete(),
                    materialsDto.getGravel(),
                    materialsDto.getSand(),
                    materialsDto.getWood(),
                    materialsDto.getAdobe());*/

    public final Function<List<MaterialEntity>, List<MaterialsDto>> mapToDtoList =
            materialEntityList -> materialEntityList.stream()
                    .map(this.mapToDto)
                    .collect(Collectors.toList());

    public MaterialEntity mapToEntity(MaterialsDto materialsDto){
        MaterialEntity materialEntity = new MaterialEntity();
        materialEntity.setId(materialsDto.getId());
        materialEntity.setConcrete(materialsDto.getConcrete());
        materialEntity.setGravel(materialsDto.getGravel());
        materialEntity.setSand(materialsDto.getSand());
        materialEntity.setWood(materialsDto.getWood());
        materialEntity.setAdobe(materialsDto.getAdobe());
        return materialEntity;
    }
}
