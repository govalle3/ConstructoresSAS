package com.ceiba.ConstructoresSAS.domain.port;

import com.ceiba.ConstructoresSAS.domain.model.dto.ConstructionDto;
import com.ceiba.ConstructoresSAS.domain.model.entity.Construction;

import java.util.List;

public interface ConstructionRepository {

    /**
     * Guarda la solicitud de construcción
     * @params construction
     * @return la construcción solicitada
     */
    Construction saveConstructionRequest(Construction construction);

    /**
     * Recupera la lista de construcciones
     * @params construction
     * @return lista de construcciones
     */
    List<ConstructionDto> findConstruction();

    /**
     * Valida si el terreno está en uso
     * @params coordinates
     * @return Boolean
     * @param coordinateX
     * @param coordinateY
     */
    Boolean validateCoordinate(String coordinateX, String coordinateY);

    /**
     * Recupera la lista de construcciones
     * @return lista de construcciones pendientes
     */
    List<ConstructionDto> findPendingConstruction();

}
