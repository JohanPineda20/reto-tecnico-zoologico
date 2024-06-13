package com.nelumbo.zoo.mappers.entity;

import com.nelumbo.zoo.model.AnimalModel;
import com.nelumbo.zoo.persistence.entity.AnimalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnimalEntityMapper {
    AnimalModel toAnimaModel(AnimalEntity animalEntity);
    AnimalEntity toAnimaMEntity(AnimalModel animalModel);
}
