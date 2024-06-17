package com.nelumbo.zoo.persistence;

import java.util.Optional;

import com.nelumbo.zoo.model.AnimalModel;
import com.nelumbo.zoo.model.CustomPage;
public interface IAnimalPersistence {

    AnimalModel save(AnimalModel animalModel1);

    CustomPage<AnimalModel> findAll(Integer page, Integer size);

    Optional<AnimalModel> findOneWithSpecieAndArea(Long id);

    void delete(AnimalModel animalModel);
}
