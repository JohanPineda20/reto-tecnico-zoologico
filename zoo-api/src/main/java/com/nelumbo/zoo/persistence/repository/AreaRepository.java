package com.nelumbo.zoo.persistence.repository;

import com.nelumbo.zoo.persistence.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<AreaEntity, Long> {

    boolean existsByName(String name);
}
