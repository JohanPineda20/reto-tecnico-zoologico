package com.nelumbo.zoo.persistence.projection.specie;

import com.nelumbo.zoo.persistence.projection.area.AreaProjection;

public interface SpecieProjectionWithArea extends SpecieProjection{
    AreaProjection getArea();
}
