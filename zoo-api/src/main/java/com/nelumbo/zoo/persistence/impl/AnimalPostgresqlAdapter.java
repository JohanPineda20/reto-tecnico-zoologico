package com.nelumbo.zoo.persistence.impl;

import com.nelumbo.zoo.mappers.entity.AnimalEntityMapper;
import com.nelumbo.zoo.persistence.IAnimalPersistence;
import com.nelumbo.zoo.persistence.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnimalPostgresqlAdapter implements IAnimalPersistence {
    private final AnimalRepository animalRepository;
    private final AnimalEntityMapper animalEntityMapper;
   
}
