package com.nelumbo.zoo.service.impl;

import com.nelumbo.zoo.model.AreaModel;
import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.model.SpecieModel;
import com.nelumbo.zoo.persistence.ISpeciePersistence;
import com.nelumbo.zoo.service.IAreaService;
import com.nelumbo.zoo.service.ISpecieService;
import com.nelumbo.zoo.utils.Constants;
import com.nelumbo.zoo.utils.exceptions.DataAlreadyExistsException;
import com.nelumbo.zoo.utils.exceptions.DataNotFoundException;
import com.nelumbo.zoo.utils.exceptions.DomainException;

import jakarta.transaction.Transactional;
import java.util.Objects;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
public class SpecieUseCase implements ISpecieService {
    
    private final ISpeciePersistence speciePersistence;
    private final IAreaService areaService;

    @Override
    public CustomPage<SpecieModel> findAll(Integer page, Integer size) {
       return speciePersistence.findAll(page, size);
    }

    @Override
    public SpecieModel findOneWithArea(Long id) {
        return speciePersistence.findOneWithArea(id).orElseThrow(() -> new DataNotFoundException(Constants.SPECIE_NOT_FOUND));
    }

    @Override
    public SpecieModel create(SpecieModel specieModel) {
        validateExistsByName(specieModel.getName());
        AreaModel areaModel = areaService.findOne(specieModel.getArea().getId());
        specieModel.setArea(areaModel);
        return speciePersistence.save(specieModel);
    }

    @Override
    public SpecieModel update(Long id, SpecieModel specieModel) {
        SpecieModel specieModel1 = this.findOneWithArea(id);
        if(specieModel.getName() != null && !specieModel.getName().equals(specieModel1.getName())) {
            validateExistsByName(specieModel.getName());
            specieModel1.setName(specieModel.getName());
        }
        if(specieModel.getArea() != null 
        && specieModel.getArea().getId() != null 
        && !Objects.equals(specieModel.getArea().getId(), specieModel1.getArea().getId())){
            AreaModel areaModel = areaService.findOne(specieModel.getArea().getId());
            specieModel1.setArea(areaModel);
        }
        return speciePersistence.save(specieModel1);
    }

    @Override
    public SpecieModel delete(Long id) {
      SpecieModel specieModel = speciePersistence.findOneWithAnimals(id).orElseThrow(() -> new DataNotFoundException(Constants.SPECIE_NOT_FOUND));
      if(!specieModel.getAnimals().isEmpty()) throw new DomainException(String.format(Constants.CANNOT_DELETE_SPECIE, specieModel.getName()));
      speciePersistence.delete(specieModel);
      return specieModel;
    }

    private void validateExistsByName(String name){
        if(speciePersistence.existsByName(name)){
            throw new DataAlreadyExistsException(String.format(Constants.SPECIE_ALREADY_EXISTS, name));
        }
    }
}