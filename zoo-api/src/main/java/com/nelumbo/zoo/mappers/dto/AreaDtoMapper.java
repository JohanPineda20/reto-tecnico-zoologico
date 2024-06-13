package com.nelumbo.zoo.mappers.dto;

import com.nelumbo.zoo.dto.request.CreateAreaRequest;
import com.nelumbo.zoo.dto.response.AreaResponse;
import com.nelumbo.zoo.model.AreaModel;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AreaDtoMapper {
    AreaModel toAreaModel (CreateAreaRequest createAreaRequest);
    AreaResponse toAreaResponse(AreaModel areaModel);
}
