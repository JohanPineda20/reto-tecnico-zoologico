package com.nelumbo.zoo.mappers.entity;

import com.nelumbo.zoo.model.RoleModel;
import com.nelumbo.zoo.persistence.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper {
    RoleModel toRolModel(RoleEntity rolEntity);
}
