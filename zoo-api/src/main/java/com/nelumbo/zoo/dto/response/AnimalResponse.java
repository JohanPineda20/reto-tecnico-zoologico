package com.nelumbo.zoo.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalResponse {
    private Long id;
    private String name;
    private SpecieResponse specie;
}
