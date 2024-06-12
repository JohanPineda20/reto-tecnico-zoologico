package com.nelumbo.zoo.persistence;

import com.nelumbo.zoo.model.RoleModel;

public interface IRolePersistence {
    RoleModel findById(Long id);
}
