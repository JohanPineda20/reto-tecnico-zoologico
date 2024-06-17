package com.nelumbo.zoo.persistence.projection.area;

import java.util.List;

import com.nelumbo.zoo.persistence.projection.specie.SpecieProjectionWithAnimals;

public interface AreaProjectionWithSpeciesAndAnimals extends AreaProjection{
    List<SpecieProjectionWithAnimals> getSpecies();
}
