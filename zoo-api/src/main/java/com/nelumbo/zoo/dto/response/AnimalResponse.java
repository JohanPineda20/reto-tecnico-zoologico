package com.nelumbo.zoo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class AnimalResponse {
    private Long id;
    private String name;
    private SpecieResponse specie;
    private List<CommentResponse> comments;
}
