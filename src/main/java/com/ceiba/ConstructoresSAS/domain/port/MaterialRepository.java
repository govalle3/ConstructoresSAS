package com.ceiba.ConstructoresSAS.domain.port;

import com.ceiba.ConstructoresSAS.domain.model.dto.MaterialsDto;

import java.util.List;

public interface MaterialRepository {

    List<MaterialsDto> getAllMaterials();
}
