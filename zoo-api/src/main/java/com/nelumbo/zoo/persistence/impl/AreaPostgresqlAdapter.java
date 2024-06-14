package com.nelumbo.zoo.persistence.impl;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

import com.nelumbo.zoo.mappers.entity.AreaEntityMapper;
import com.nelumbo.zoo.model.AreaModel;
import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.persistence.IAreaPersistence;
import com.nelumbo.zoo.persistence.repository.AreaRepository;
import com.nelumbo.zoo.utils.CustomPageConverter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AreaPostgresqlAdapter implements IAreaPersistence {

    private final AreaRepository areaRepository;
    private final AreaEntityMapper areaEntityMapper;
  
    @Override
    public AreaModel save(AreaModel areaModel) {
       return areaEntityMapper.toAreaModel(areaRepository.save(areaEntityMapper.toAreaEntity(areaModel)));
    }
    @Override
    public boolean existsByName(String name) {
        return areaRepository.existsByName(name);
    }
    @Override
    public Optional<AreaModel> findOneWithSpecies(Long id) {
        return areaRepository.getAreaWithSpeciesById(id).map(areaEntityMapper::areaProjectionWithSpeciesToAreaModel);
    }
    @Override
    public Optional<AreaModel> findOneWithSpeciesAndAnimals(Long id) {
        return areaRepository.getAreaWithSpeciesAndAnimalsById(id).map(areaEntityMapper::areaProjectionWithSpeciesAndAnimalsToAreaModel);
    }
    @Override
    public CustomPage<AreaModel> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));
        return CustomPageConverter.convertPage(areaRepository.findAllBy(pageable), areaEntityMapper::areaProjectionWithSpeciesToAreaModel);
    }
    @Override
    public void delete(AreaModel areaModel) {
        areaRepository.delete(areaEntityMapper.toAreaEntity(areaModel));
    }
}
