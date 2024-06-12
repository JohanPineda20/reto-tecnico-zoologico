package com.nelumbo.zoo.persistence.impl;

import com.nelumbo.zoo.model.RoleModel;
import com.nelumbo.zoo.persistence.IRolePersistence;
import com.nelumbo.zoo.mappers.entity.RoleEntityMapper;
import com.nelumbo.zoo.persistence.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RolePostgresqlAdapter implements IRolePersistence {
    private final RoleRepository rolRepository;
    private final RoleEntityMapper rolEntityMapper;
    @Override
    public RoleModel findById(Long id) {
        return rolEntityMapper.toRolModel(rolRepository.findById(id).orElse(null));
    }
}
