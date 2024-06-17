package com.nelumbo.zoo.persistence.impl;

import java.util.Optional;

import com.nelumbo.zoo.persistence.entity.AnimalEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.nelumbo.zoo.mappers.entity.AnimalEntityMapper;
import com.nelumbo.zoo.model.AnimalModel;
import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.persistence.IAnimalPersistence;
import com.nelumbo.zoo.persistence.repository.AnimalRepository;
import com.nelumbo.zoo.utils.CustomPageConverter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnimalPostgresqlAdapter implements IAnimalPersistence {
    private final AnimalRepository animalRepository;
    private final AnimalEntityMapper animalEntityMapper;
    @Override
    public AnimalModel save(AnimalModel animalModel) {
        AnimalEntity animalEntity = animalRepository.save(animalEntityMapper.toAnimalEntity(animalModel));
        animalEntity.getSpecie().setAnimals(null);
        animalEntity.getSpecie().getArea().setSpecies(null);
        return animalEntityMapper.toAnimalModel(animalEntity);
    }
    @Override
    public CustomPage<AnimalModel> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));
        return CustomPageConverter.convertPage(animalRepository.findAllBy(pageable), animalEntityMapper::animalProjectionWithSpecieAndAreaToAnimalModel);
    }
    @Override
    public Optional<AnimalModel> findOneWithSpecieAndArea(Long id) {
        return animalRepository.getAnimalWithSpecieAndAreaById(id).map(animalEntityMapper::animalProjectionWithSpecieAndAreaToAnimalModel);
    }
    @Override
    public void delete(AnimalModel animalModel) {
        animalRepository.deleteById(animalModel.getId());
    }
}
