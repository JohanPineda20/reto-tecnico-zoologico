package com.nelumbo.zoo.mappers.entity;

import com.nelumbo.zoo.model.SpecieModel;
import com.nelumbo.zoo.persistence.entity.SpecieEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SpecieEntityMapper {
    SpecieModel toSpecieModel(SpecieEntity specieEntity);
    SpecieEntity toSpecieEntity(SpecieModel specieModel);
}
