package com.nelumbo.zoo.persistence.repository;

import com.nelumbo.zoo.persistence.entity.SpecieEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecieRepository extends JpaRepository<SpecieEntity, Long> {
}
