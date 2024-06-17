package com.nelumbo.zoo.service.impl;

import com.nelumbo.zoo.model.AnimalModel;
import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.model.SpecieModel;
import com.nelumbo.zoo.persistence.IAnimalPersistence;
import com.nelumbo.zoo.service.IAnimalService;
import com.nelumbo.zoo.service.ISpecieService;
import com.nelumbo.zoo.utils.Constants;
import com.nelumbo.zoo.utils.exceptions.DataNotFoundException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
public class AnimalUseCase implements IAnimalService {

    private final IAnimalPersistence animalPersistence;
    private final ISpecieService specieService;

    @Override
    public CustomPage<AnimalModel> findAll(Integer page, Integer size) {
       return animalPersistence.findAll(page, size);
    }

    @Override
    public AnimalModel findOneWithSpecieAndArea(Long id) {
        return animalPersistence.findOneWithSpecieAndArea(id).orElseThrow(() -> new DataNotFoundException(Constants.ANIMAL_NOT_FOUND));
    }

    @Override
    public AnimalModel create(AnimalModel animalModel) {
       SpecieModel specieModel = specieService.findOneWithArea(animalModel.getSpecie().getId());
       animalModel.setSpecie(specieModel);
       return animalPersistence.save(animalModel);
    }

    @Override
    public AnimalModel update(Long id, AnimalModel animalModel) {
        AnimalModel animalModel1 = this.findOneWithSpecieAndArea(id);
        if(animalModel.getName() != null && !animalModel.getName().equals(animalModel1.getName())) {
            animalModel1.setName(animalModel.getName());
        }
        if(animalModel.getSpecie() != null
        && animalModel.getSpecie().getId() != null
        && !animalModel.getSpecie().getId().equals(animalModel1.getSpecie().getId())){
            SpecieModel specieModel = specieService.findOneWithArea(animalModel.getSpecie().getId());
            animalModel1.setSpecie(specieModel);
        }
        return animalPersistence.save(animalModel1);
    }

    @Override
    public AnimalModel delete(Long id) {
        AnimalModel animalModel = this.findOneWithSpecieAndArea(id);
        animalPersistence.delete(animalModel);
        return animalModel;
    }

}