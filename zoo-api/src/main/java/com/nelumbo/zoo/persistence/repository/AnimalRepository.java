package com.nelumbo.zoo.persistence.repository;

import com.nelumbo.zoo.persistence.entity.AnimalEntity;
import com.nelumbo.zoo.persistence.projection.animal.AnimalProjectionWithSpecieAndArea;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

    Page<AnimalProjectionWithSpecieAndArea> findAllBy(Pageable pageable);

    Optional<AnimalProjectionWithSpecieAndArea> getAnimalWithSpecieAndAreaById(Long id);
}
