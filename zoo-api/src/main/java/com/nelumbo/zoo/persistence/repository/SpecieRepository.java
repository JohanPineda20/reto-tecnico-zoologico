package com.nelumbo.zoo.persistence.repository;

import java.util.Optional;

import com.nelumbo.zoo.persistence.entity.SpecieEntity;
import com.nelumbo.zoo.persistence.projection.specie.SpecieProjectionWithAnimals;
import com.nelumbo.zoo.persistence.projection.specie.SpecieProjectionWithArea;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecieRepository extends JpaRepository<SpecieEntity, Long> {

    boolean existsByName(String name);

    Optional<SpecieProjectionWithArea> getSpecieWithAreaById(Long id);

    Optional<SpecieProjectionWithAnimals> getSpecieWithAnimalsById(Long id);

    Page<SpecieProjectionWithArea> findAllBy(Pageable pageable);
}
