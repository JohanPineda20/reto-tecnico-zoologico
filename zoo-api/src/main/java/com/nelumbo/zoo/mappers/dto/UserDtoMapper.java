package com.nelumbo.zoo.mappers.dto;

import com.nelumbo.zoo.dto.request.UserRequest;
import com.nelumbo.zoo.dto.response.UserResponse;
import com.nelumbo.zoo.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {
    UserModel toUserModel (UserRequest userRequest);
    @Mapping(target="role", source="role.name")
    UserResponse toUserResponse(UserModel userModel);
}
