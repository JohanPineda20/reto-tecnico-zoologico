package com.nelumbo.zoo.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class AreaResponse {
    private Long id;
    private String name;
    private List<SpecieResponse> species;
}
