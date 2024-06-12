package com.nelumbo.zoo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelumbo.zoo.dto.request.UserRequest;
import com.nelumbo.zoo.dto.response.UserResponse;
import com.nelumbo.zoo.mappers.dto.UserDtoMapper;
import com.nelumbo.zoo.model.UserModel;
import com.nelumbo.zoo.service.IUserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    private final UserDtoMapper userDtoMapper;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserResponse> createSocio(@Valid @RequestBody UserRequest userRequest){
        UserModel userModel = userService.createSocio(userDtoMapper.toUserModel(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(userDtoMapper.toUserResponse(userModel));
    }
}
