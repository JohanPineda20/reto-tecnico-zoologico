package com.nelumbo.zoo.persistence;

import java.util.Optional;

import com.nelumbo.zoo.model.AreaModel;
import com.nelumbo.zoo.model.CustomPage;

public interface IAreaPersistence {

    AreaModel save(AreaModel areaModel);

    boolean existsByName(String name);

    Optional<AreaModel> findOne(Long id);

    Optional<AreaModel> findOneWithSpecies(Long id);

    Optional<AreaModel> findOneWithSpeciesAndAnimals(Long id);

    CustomPage<AreaModel> findAll(Integer page, Integer size);

    void delete(AreaModel areaModel);

    Optional<AreaModel> findAnimalsByArea(Long id);
}
