package com.nelumbo.zoo.mappers.entity;

import com.nelumbo.zoo.model.SpecieModel;
import com.nelumbo.zoo.persistence.entity.SpecieEntity;
import com.nelumbo.zoo.persistence.projection.specie.SpecieProjectionWithAnimals;
import com.nelumbo.zoo.persistence.projection.specie.SpecieProjectionWithArea;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SpecieEntityMapper {

    SpecieModel specieProjectionWithAreaToSpecieModel(SpecieProjectionWithArea specieProjectionWithArea);
    SpecieModel specieProjectionWithAnimalsToSpecieModel(SpecieProjectionWithAnimals specieProjectionWithAnimals);

    SpecieModel toSpecieModel(SpecieEntity specieEntity);
    SpecieEntity toSpecieEntity(SpecieModel specieModel);
}
