package com.nelumbo.zoo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AreaModel {
    private Long id;
    private String name;
    List<SpecieModel> species;
}
