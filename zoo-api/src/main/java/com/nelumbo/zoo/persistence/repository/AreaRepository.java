package com.nelumbo.zoo.persistence.repository;

import java.util.Optional;
import com.nelumbo.zoo.persistence.entity.AreaEntity;
import com.nelumbo.zoo.persistence.projection.area.AreaProjectionWithSpecies;
import com.nelumbo.zoo.persistence.projection.area.AreaProjectionWithSpeciesAndAnimals;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<AreaEntity, Long> {

    boolean existsByName(String name);

    Page<AreaProjectionWithSpecies> findAllBy(Pageable pageable);

    Optional<AreaProjectionWithSpecies> getAreaWithSpeciesById(Long id);
    
    Optional<AreaProjectionWithSpeciesAndAnimals> getAreaWithSpeciesAndAnimalsById(Long id);
}
