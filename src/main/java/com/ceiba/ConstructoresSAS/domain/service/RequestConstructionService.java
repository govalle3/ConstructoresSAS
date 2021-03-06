package com.ceiba.ConstructoresSAS.domain.service;

import com.ceiba.ConstructoresSAS.domain.exception.ExceptionCoordinates;
import com.ceiba.ConstructoresSAS.domain.exception.ExceptionMaterials;
import com.ceiba.ConstructoresSAS.domain.model.dto.ConstructionDto;
import com.ceiba.ConstructoresSAS.domain.model.dto.MaterialsDto;
import com.ceiba.ConstructoresSAS.domain.model.entity.Construction;
import com.ceiba.ConstructoresSAS.domain.port.ConstructionRepository;
import com.ceiba.ConstructoresSAS.domain.port.MaterialRepository;

import java.time.LocalDate;
import java.util.List;

public class RequestConstructionService {

    public static final String MESSAGE_USED_TERRAIN = "El terreno seleccionado ya fue ocupado";
    public static final String MESSAGE_MISSING_CONCRETE = "No posee recursos de cemento";
    public static final String MESSAGE_MISSING_GRAVEL = "No posee recursos de grava";
    public static final String MESSAGE_MISSING_SAND = "No posee recursos de arena";
    public static final String MESSAGE_MISSING_WOOD = "No posee recursos de madera";
    public static final String MESSAGE_MISSING_ADOBE = "No posee recursos de adobe";
    private final ConstructionRepository constructionRepository;
    private final MaterialRepository materialRepository;


    public RequestConstructionService(ConstructionRepository constructionRepository, MaterialRepository materialRepository) {
        this.constructionRepository = constructionRepository;
        this.materialRepository = materialRepository;
    }

    public Construction validateAndAssignConstructionRequest(Construction construction){
        validateUsedTerrain(construction);
        Integer dueDate = validateAndAssignTypeOfConstruction(construction.getConstructionType());
        assignDateConstruction(construction, dueDate);
        return create(construction);
    }

    private void validateUsedTerrain(Construction construction) {
        if (this.constructionRepository.validateCoordinate(construction.getCoordinateX(),construction.getCoordinateY())) {
            throw new ExceptionCoordinates(MESSAGE_USED_TERRAIN);
        }
    }
    private Integer validateAndAssignTypeOfConstruction(String constructionType) {

        switch (constructionType){
            case "Casa":
                validateHouseMaterials();
                return 3;
            case "Lago":
                validateLakeMaterials();
                return 2;
            case "Cancha de futbol":
                validateSoccerFieldMaterials();
                return 1;
            case "Edificio":
                validateBuildingMaterials();
                return 6;
            case "Gimnasio":
                validateGymMaterials();
                return 2;
        }
        return 0;

    }
    private void validateHouseMaterials() {
        MaterialsDto materials = materialRepository.getAllMaterials().get(0);
        if(materials.getConcrete() < 100){
            throw new ExceptionMaterials(MESSAGE_MISSING_CONCRETE);
        }
        if(materials.getGravel() < 50){
            throw new ExceptionMaterials(MESSAGE_MISSING_GRAVEL);
        }
        if(materials.getSand() < 90){
            throw new ExceptionMaterials(MESSAGE_MISSING_SAND);
        }
        if(materials.getWood() < 20){
            throw new ExceptionMaterials(MESSAGE_MISSING_WOOD);
        }
        if(materials.getAdobe() < 100){
            throw new ExceptionMaterials(MESSAGE_MISSING_ADOBE);
        }
        updateHouseMaterials(materials);

    }
    private void updateHouseMaterials(MaterialsDto materials) {
        materials.setConcrete(materials.getConcrete()-100);
        materials.setGravel(materials.getGravel()-50);
        materials.setSand(materials.getSand()-90);
        materials.setWood(materials.getWood()-20);
        materials.setAdobe(materials.getAdobe()-100);
        materialRepository.updateMaterials(materials);

    }
    private void validateLakeMaterials() {
        MaterialsDto materials = materialRepository.getAllMaterials().get(0);
        if(materials.getConcrete() < 50){
            throw new ExceptionMaterials(MESSAGE_MISSING_CONCRETE);
        }
        if(materials.getGravel() < 60){
            throw new ExceptionMaterials(MESSAGE_MISSING_GRAVEL);
        }
        if(materials.getSand() < 80){
            throw new ExceptionMaterials(MESSAGE_MISSING_SAND);
        }
        if(materials.getWood() < 10){
            throw new ExceptionMaterials(MESSAGE_MISSING_WOOD);
        }
        if(materials.getAdobe() < 20){
            throw new ExceptionMaterials(MESSAGE_MISSING_ADOBE);
        }
        updateLakeMaterials(materials);
    }
    private void updateLakeMaterials(MaterialsDto materials) {
        materials.setConcrete(materials.getConcrete()-50);
        materials.setGravel(materials.getGravel()-60);
        materials.setSand(materials.getSand()-80);
        materials.setWood(materials.getWood()-10);
        materials.setAdobe(materials.getAdobe()-20);
        materialRepository.updateMaterials(materials);

    }
    private void validateSoccerFieldMaterials() {
        MaterialsDto materials = materialRepository.getAllMaterials().get(0);
        if(materials.getConcrete() < 20){
            throw new ExceptionMaterials(MESSAGE_MISSING_CONCRETE);
        }
        if(materials.getGravel() < 20){
            throw new ExceptionMaterials(MESSAGE_MISSING_GRAVEL);
        }
        if(materials.getSand() < 20){
            throw new ExceptionMaterials(MESSAGE_MISSING_SAND);
        }
        if(materials.getWood() < 20){
            throw new ExceptionMaterials(MESSAGE_MISSING_WOOD);
        }
        if(materials.getAdobe() < 20){
            throw new ExceptionMaterials(MESSAGE_MISSING_ADOBE);
        }
        updateSoccerMaterials(materials);
    }
    private void updateSoccerMaterials(MaterialsDto materials) {
        materials.setConcrete(materials.getConcrete()-20);
        materials.setGravel(materials.getGravel()-20);
        materials.setSand(materials.getSand()-20);
        materials.setWood(materials.getWood()-20);
        materials.setAdobe(materials.getAdobe()-20);
        materialRepository.updateMaterials(materials);

    }
    private void validateBuildingMaterials() {
        MaterialsDto materials = materialRepository.getAllMaterials().get(0);
        if(materials.getConcrete() < 200){
            throw new ExceptionMaterials(MESSAGE_MISSING_CONCRETE);
        }
        if(materials.getGravel() < 100){
            throw new ExceptionMaterials(MESSAGE_MISSING_GRAVEL);
        }
        if(materials.getSand() < 180){
            throw new ExceptionMaterials(MESSAGE_MISSING_SAND);
        }
        if(materials.getWood() < 40){
            throw new ExceptionMaterials(MESSAGE_MISSING_WOOD);
        }
        if(materials.getAdobe() < 200){
            throw new ExceptionMaterials(MESSAGE_MISSING_ADOBE);
        }
        updateBuildingMaterials(materials);

    }
    private void updateBuildingMaterials(MaterialsDto materials) {
        materials.setConcrete(materials.getConcrete()-200);
        materials.setGravel(materials.getGravel()-100);
        materials.setSand(materials.getSand()-180);
        materials.setWood(materials.getWood()-40);
        materials.setAdobe(materials.getAdobe()-200);
        materialRepository.updateMaterials(materials);

    }
    private void validateGymMaterials() {
        MaterialsDto materials = materialRepository.getAllMaterials().get(0);
        if(materials.getConcrete() < 50){
            throw new ExceptionMaterials(MESSAGE_MISSING_CONCRETE);
        }
        if(materials.getGravel() < 25){
            throw new ExceptionMaterials(MESSAGE_MISSING_GRAVEL);
        }
        if(materials.getSand() < 45){
            throw new ExceptionMaterials(MESSAGE_MISSING_SAND);
        }
        if(materials.getWood() < 10){
            throw new ExceptionMaterials(MESSAGE_MISSING_WOOD);
        }
        if(materials.getAdobe() < 50){
            throw new ExceptionMaterials(MESSAGE_MISSING_ADOBE);
        }
        updateGymMaterials(materials);

    }
    private void updateGymMaterials(MaterialsDto materials) {
        materials.setConcrete(materials.getConcrete()-50);
        materials.setGravel(materials.getGravel()-25);
        materials.setSand(materials.getSand()-45);
        materials.setWood(materials.getWood()-10);
        materials.setAdobe(materials.getAdobe()-50);
        materialRepository.updateMaterials(materials);

    }
    private void assignDateConstruction(Construction construction, Integer dueDate) {
        LocalDate requestDay = construction.getRequestDay();
        List<ConstructionDto> constructionDtoList = this.constructionRepository.findPendingConstruction();
        LocalDate startConstructionDay = requestDay.plusDays(1);
        LocalDate finishConstructionDay = startConstructionDay.plusDays(dueDate);
        construction.setStartConstructionDay(startConstructionDay);
        construction.setFinishConstructionDay(finishConstructionDay);
    }
    private Construction create(Construction construction) {
        construction.setState("pendiente");
        return this.constructionRepository.saveConstructionRequest(construction);
    }


}
