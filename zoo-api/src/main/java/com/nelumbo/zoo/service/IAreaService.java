package com.nelumbo.zoo.service;

import com.nelumbo.zoo.model.AreaModel;
import com.nelumbo.zoo.model.CustomPage;

public interface IAreaService {

    AreaModel create(AreaModel areaModel);

    AreaModel findOne(Long id);

    CustomPage<AreaModel> findAll(Integer page, Integer size);

    AreaModel update(Long id, AreaModel areaModel);

    AreaModel delete(Long id);
}
