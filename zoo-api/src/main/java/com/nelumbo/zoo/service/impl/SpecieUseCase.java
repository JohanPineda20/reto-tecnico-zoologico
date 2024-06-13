package com.nelumbo.zoo.service.impl;

import com.nelumbo.zoo.persistence.ISpeciePersistence;
import com.nelumbo.zoo.service.ISpecieService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
public class SpecieUseCase implements ISpecieService {
    
    private final ISpeciePersistence speciePersistence;
}