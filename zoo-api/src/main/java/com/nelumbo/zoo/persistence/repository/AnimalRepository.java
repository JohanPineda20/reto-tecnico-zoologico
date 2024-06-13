package com.nelumbo.zoo.persistence.repository;

import com.nelumbo.zoo.persistence.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
}
