package com.nelumbo.zoo.persistence.projection.area;

import com.nelumbo.zoo.persistence.projection.specie.SpecieProjectionWithAnimalsAndComments;

import java.util.List;

public interface AreaProjectionWithSpeciesAndAnimalsAndComments extends AreaProjection{
    List<SpecieProjectionWithAnimalsAndComments> getSpecies();
}
