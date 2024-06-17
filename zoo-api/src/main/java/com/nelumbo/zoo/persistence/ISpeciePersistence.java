package com.nelumbo.zoo.persistence;

import java.util.Optional;

import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.model.SpecieModel;

public interface ISpeciePersistence {

    boolean existsByName(String name);

    SpecieModel save(SpecieModel specieModel);

    Optional<SpecieModel> findOneWithArea(Long id);

    Optional<SpecieModel> findOneWithAnimals(Long id);

    CustomPage<SpecieModel> findAll(Integer page, Integer size);

    void delete(SpecieModel specieModel);
}
