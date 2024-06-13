package com.nelumbo.zoo.persistence.impl;

import com.nelumbo.zoo.mappers.entity.SpecieEntityMapper;
import com.nelumbo.zoo.persistence.ISpeciePersistence;
import com.nelumbo.zoo.persistence.repository.SpecieRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpeciePostgresqlAdapter implements ISpeciePersistence {
    private final SpecieRepository specieRepository;
    private final SpecieEntityMapper specieEntityMapper;

  
}
