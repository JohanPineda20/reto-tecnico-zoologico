package com.nelumbo.zoo.persistence.projection.specie;
import java.util.List;

import com.nelumbo.zoo.persistence.projection.animal.AnimalProjection;
public interface SpecieProjectionWithAnimals extends SpecieProjection{
    List<AnimalProjection> getAnimals();
}
