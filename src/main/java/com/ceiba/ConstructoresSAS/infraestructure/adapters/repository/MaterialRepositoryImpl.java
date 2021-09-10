package com.ceiba.ConstructoresSAS.infraestructure.adapters.repository;

import com.ceiba.ConstructoresSAS.domain.model.dto.MaterialsDto;
import com.ceiba.ConstructoresSAS.domain.port.MaterialRepository;
import com.ceiba.ConstructoresSAS.infraestructure.adapters.MaterialJpaRepository;
import com.ceiba.ConstructoresSAS.infraestructure.adapters.mapper.MaterialMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MaterialRepositoryImpl implements MaterialRepository {

    private final MaterialJpaRepository materialJpaRepository;
    private final MaterialMapper materialMapper;

    @Override
    public List<MaterialsDto> getAllMaterials() {
        return materialMapper.mapToDtoList.apply(this.materialJpaRepository.findAll());
    }
}
