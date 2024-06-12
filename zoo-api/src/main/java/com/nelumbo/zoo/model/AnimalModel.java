package com.nelumbo.zoo.model;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnimalModel {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private SpecieModel specie;
    private List<CommentModel> comments;
}
