package com.nelumbo.zoo.persistence.repository;

import com.nelumbo.zoo.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
