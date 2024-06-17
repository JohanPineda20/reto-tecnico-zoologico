package com.nelumbo.zoo.service;

import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.model.SpecieModel;

public interface ISpecieService {

    CustomPage<SpecieModel> findAll(Integer page, Integer size);

    SpecieModel findOneWithArea(Long id);

    SpecieModel create(SpecieModel specieModel);

    SpecieModel update(Long id, SpecieModel specieModel);

    SpecieModel delete(Long id);

}