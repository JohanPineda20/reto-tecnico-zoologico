package com.nelumbo.zoo.mappers.dto;

import com.nelumbo.zoo.dto.request.CreateSpecieRequest;
import com.nelumbo.zoo.dto.response.SpecieResponse;
import com.nelumbo.zoo.model.SpecieModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SpecieDtoMapper {
    @Mapping(target = "area.id", source = "areaId")
    SpecieModel toSpecieModel (CreateSpecieRequest createSpecieRequest);
    @Mapping(target = "area.species", ignore = true)
    SpecieResponse toSpecieResponse (SpecieModel specieModel);
}
