package com.nelumbo.zoo.service.impl;

import com.nelumbo.zoo.model.UserModel;
import com.nelumbo.zoo.service.IUserService;
import com.nelumbo.zoo.security.passwordencoder.IPasswordEncoder;
import com.nelumbo.zoo.persistence.IRolePersistence;
import com.nelumbo.zoo.persistence.IUserPersistence;
import com.nelumbo.zoo.utils.Constants;
import com.nelumbo.zoo.utils.exceptions.DataAlreadyExistsException;
import com.nelumbo.zoo.utils.exceptions.DataNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
public class UserUseCase implements IUserService {
    private final IUserPersistence userPersistencePort;
    private final IRolePersistence rolePersistencePort;
    private final IPasswordEncoder passwordEncoderPort;
    @Override
    public UserModel createSocio(UserModel userModel) {
        if(userPersistencePort.existsByDniNumber(userModel.getDni())){
            throw new DataAlreadyExistsException(String.format(Constants.USER_ALREADY_EXISTS, Constants.DNI, userModel.getDni()));
        }
        if(userPersistencePort.existsByEmail(userModel.getEmail())){
            throw new DataAlreadyExistsException(String.format(Constants.USER_ALREADY_EXISTS, Constants.EMAIL, userModel.getEmail()));
        }
        var role = rolePersistencePort.findById(Constants.ID_EMPLOYEE);
        if(role == null) throw new DataNotFoundException(Constants.ROLE_NOT_FOUND);

        userModel.setRole(role);
        userModel.setPassword(passwordEncoderPort.encode(userModel.getPassword()));
        return userPersistencePort.save(userModel);
    }
    @Override
    public UserModel findById(Long id){
        var userModel = userPersistencePort.findById(id);
        if(userModel == null) throw new DataNotFoundException(Constants.USER_NOT_FOUND);
        return userModel;
    }
}
