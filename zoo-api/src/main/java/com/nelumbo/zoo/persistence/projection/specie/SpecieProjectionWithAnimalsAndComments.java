package com.nelumbo.zoo.persistence.projection.specie;

import com.nelumbo.zoo.persistence.projection.animal.AnimalProjectionWithComments;

import java.util.List;

public interface SpecieProjectionWithAnimalsAndComments extends SpecieProjection {
    List<AnimalProjectionWithComments> getAnimals();
}
