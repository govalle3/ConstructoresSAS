package com.ceiba.ConstructoresSAS.infraestructure.adapters.mapper;

import com.ceiba.ConstructoresSAS.domain.model.dto.MaterialsDto;
import com.ceiba.ConstructoresSAS.infraestructure.adapters.entity.MaterialEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MaterialMapper {

    public final Function<MaterialEntity, MaterialsDto> mapToDto =
            materialEntity -> new MaterialsDto(materialEntity.getConcrete(),
                    materialEntity.getGravel(), materialEntity.getSand(),
                    materialEntity.getWood(), materialEntity.getAdobe());

    public final Function<List<MaterialEntity>, List<MaterialsDto>> mapToDtoList =
            materialEntityList -> materialEntityList.stream()
                    .map(this.mapToDto)
                    .collect(Collectors.toList());
}
