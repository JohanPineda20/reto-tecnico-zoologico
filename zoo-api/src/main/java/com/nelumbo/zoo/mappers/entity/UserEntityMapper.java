package com.nelumbo.zoo.mappers.entity;

import com.nelumbo.zoo.model.UserModel;
import com.nelumbo.zoo.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    UserEntity toUserEntity(UserModel userModel);

    UserModel toUserModel(UserEntity userEntity);
}
