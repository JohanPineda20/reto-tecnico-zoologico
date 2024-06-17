package com.nelumbo.zoo.persistence.impl;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.nelumbo.zoo.mappers.entity.SpecieEntityMapper;
import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.model.SpecieModel;
import com.nelumbo.zoo.persistence.ISpeciePersistence;
import com.nelumbo.zoo.persistence.entity.SpecieEntity;
import com.nelumbo.zoo.persistence.repository.SpecieRepository;
import com.nelumbo.zoo.utils.CustomPageConverter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpeciePostgresqlAdapter implements ISpeciePersistence {
    private final SpecieRepository specieRepository;
    private final SpecieEntityMapper specieEntityMapper;
    @Override
    public boolean existsByName(String name) {
        return specieRepository.existsByName(name);
    }
    @Override
    public SpecieModel save(SpecieModel specieModel) {
        SpecieEntity specieEntity = specieRepository.save(specieEntityMapper.toSpecieEntity(specieModel));
        specieEntity.getArea().setSpecies(null);
        return specieEntityMapper.toSpecieModel(specieEntity);
    }
    @Override
    public Optional<SpecieModel> findOneWithArea(Long id) {
       return specieRepository.getSpecieWithAreaById(id).map(specieEntityMapper::specieProjectionWithAreaToSpecieModel);
    }
    @Override
    public Optional<SpecieModel> findOneWithAnimals(Long id) {
       return specieRepository.getSpecieWithAnimalsById(id).map(specieEntityMapper::specieProjectionWithAnimalsToSpecieModel);
    }
    @Override
    public CustomPage<SpecieModel> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));
        return CustomPageConverter.convertPage(specieRepository.findAllBy(pageable), specieEntityMapper::specieProjectionWithAreaToSpecieModel);
    }
    @Override
    public void delete(SpecieModel specieModel) {
        specieRepository.delete(specieEntityMapper.toSpecieEntity(specieModel));
    }
}
