package com.nelumbo.zoo.mappers.dto;

import com.nelumbo.zoo.dto.request.CreateAnimalRequest;
import com.nelumbo.zoo.model.AnimalModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnimalDtoMapper {
    AnimalModel toAreaModel (CreateAnimalRequest createAreaRequest);
}
