package com.nelumbo.zoo.persistence.projection.area;

import java.util.List;

import com.nelumbo.zoo.persistence.projection.specie.SpecieProjection;

public interface AreaProjectionWithSpecies extends AreaProjection {
    List<SpecieProjection> getSpecies();
}
