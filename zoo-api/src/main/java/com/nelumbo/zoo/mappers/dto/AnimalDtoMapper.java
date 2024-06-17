package com.nelumbo.zoo.mappers.dto;

import com.nelumbo.zoo.dto.request.CreateAnimalRequest;
import com.nelumbo.zoo.dto.response.AnimalResponse;
import com.nelumbo.zoo.model.AnimalModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnimalDtoMapper {
    @Mapping(target = "specie.id", source = "specieId")
    AnimalModel toAnimalModel (CreateAnimalRequest createAreaRequest);
    AnimalResponse toAnimalResponse(AnimalModel animalModel);
}
