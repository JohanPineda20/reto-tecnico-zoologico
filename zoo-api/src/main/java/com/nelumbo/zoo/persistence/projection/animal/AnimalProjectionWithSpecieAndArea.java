package com.nelumbo.zoo.persistence.projection.animal;

import com.nelumbo.zoo.persistence.projection.specie.SpecieProjectionWithArea;

public interface AnimalProjectionWithSpecieAndArea extends AnimalProjection{
    SpecieProjectionWithArea getSpecie();
}
