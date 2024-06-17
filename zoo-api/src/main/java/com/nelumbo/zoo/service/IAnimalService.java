package com.nelumbo.zoo.service;

import com.nelumbo.zoo.model.AnimalModel;
import com.nelumbo.zoo.model.CustomPage;

public interface IAnimalService {

    CustomPage<AnimalModel> findAll(Integer page, Integer size);

    AnimalModel findOneWithSpecieAndArea(Long id);

    AnimalModel create(AnimalModel animalModel);

    AnimalModel update(Long id, AnimalModel animalModel);

    AnimalModel delete(Long id);

}
