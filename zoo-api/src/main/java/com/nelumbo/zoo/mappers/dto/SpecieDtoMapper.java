package com.nelumbo.zoo.mappers.dto;

import com.nelumbo.zoo.dto.request.CreateSpecieRequest;
import com.nelumbo.zoo.model.SpecieModel;

import org.mapstruct.Mapper;

import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SpecieDtoMapper {
    SpecieModel toAreaModel (CreateSpecieRequest createSpecieRequest);
}
