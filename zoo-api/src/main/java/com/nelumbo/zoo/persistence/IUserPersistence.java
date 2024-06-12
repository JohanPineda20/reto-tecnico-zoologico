package com.nelumbo.zoo.persistence;

import com.nelumbo.zoo.model.UserModel;

public interface IUserPersistence {
    UserModel save(UserModel userModel);
    boolean existsByDniNumber(String dniNumber);
    boolean existsByEmail(String email);
    UserModel findById(Long id);
}
