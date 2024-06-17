package com.nelumbo.zoo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class SpecieResponse {
    private Long id;
    private String name;
    private AreaResponse area;
    private List<AnimalResponse> animals;
}