package com.nelumbo.zoo.service.impl;

import com.nelumbo.zoo.model.AreaModel;
import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.model.SpecieModel;
import com.nelumbo.zoo.persistence.IAreaPersistence;
import com.nelumbo.zoo.service.IAreaService;
import com.nelumbo.zoo.utils.Constants;
import com.nelumbo.zoo.utils.exceptions.DataAlreadyExistsException;
import com.nelumbo.zoo.utils.exceptions.DataNotFoundException;
import com.nelumbo.zoo.utils.exceptions.DomainException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
public class AreaUseCase implements IAreaService {

    private final IAreaPersistence areaPersistence;

    @Override
    public AreaModel create(AreaModel areaModel) {
        validateExistsByName(areaModel.getName());
        return areaPersistence.save(areaModel);
    }

    private void validateExistsByName(String name){
        if(areaPersistence.existsByName(name)){
            throw new DataAlreadyExistsException(String.format(Constants.AREA_ALREADY_EXISTS, name));
        }
    }

    @Override
    public AreaModel findOne(Long id) {
        return areaPersistence.findOneWithSpeciesAndAnimals(id).orElseThrow(() -> new DataNotFoundException(Constants.AREA_NOT_FOUND));
    }

    @Override
    public AreaModel findOneWithSpecies(Long id) {
        return areaPersistence.findOneWithSpecies(id).orElseThrow(() -> new DataNotFoundException(Constants.AREA_NOT_FOUND));
    }

    @Override
    public CustomPage<AreaModel> findAll(Integer page, Integer size) {
        return areaPersistence.findAll(page, size);
    }

    @Override
    public AreaModel update(Long id, AreaModel areaModel) {
        AreaModel areaModel1 = areaPersistence.findOne(id).orElseThrow(() -> new DataNotFoundException(Constants.AREA_NOT_FOUND));
        if(areaModel.getName() != null && !areaModel.getName().equals(areaModel1.getName())) {
            validateExistsByName(areaModel.getName());
            areaModel1.setName(areaModel.getName());
        }
        return areaPersistence.save(areaModel1);
    }

    @Override
    public AreaModel delete(Long id) {
       AreaModel areaModel = this.findOne(id);
       for (SpecieModel specieModel: areaModel.getSpecies()) {
            if(!specieModel.getAnimals().isEmpty()){
                throw new DomainException(String.format(Constants.CANNOT_DELETE_AREA, areaModel.getName(), specieModel.getName()));
            }
       }
       areaPersistence.delete(areaModel);
       return areaModel;
    }

    @Override
    public AreaModel findAnimalsByArea(Long id) {
        return areaPersistence.findAnimalsByArea(id).orElseThrow(() -> new DataNotFoundException(Constants.AREA_NOT_FOUND));
    }
}