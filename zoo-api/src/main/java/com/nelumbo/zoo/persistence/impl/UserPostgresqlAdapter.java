package com.nelumbo.zoo.persistence.impl;

import com.nelumbo.zoo.model.UserModel;
import com.nelumbo.zoo.persistence.IUserPersistence;
import com.nelumbo.zoo.mappers.entity.UserEntityMapper;
import com.nelumbo.zoo.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserPostgresqlAdapter implements IUserPersistence {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    @Override
    public UserModel save(UserModel userModel) {
        return userEntityMapper.toUserModel(userRepository.save(userEntityMapper.toUserEntity(userModel)));
    }
    @Override
    public boolean existsByDniNumber(String dni) {
        return userRepository.existsByDni(dni);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    @Override
    public UserModel findById(Long id) {
        return userEntityMapper.toUserModel(userRepository.findById(id).orElse(null));
    }
}
