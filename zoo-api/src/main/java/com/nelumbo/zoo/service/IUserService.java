package com.nelumbo.zoo.service;

import com.nelumbo.zoo.model.UserModel;

public interface IUserService {
    UserModel createSocio(UserModel userModel);
    UserModel findById(Long id);
}
