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
public class CommentModel {
    private Long id;
    private String body;
    private UserModel author;
    private LocalDateTime createdAt;
    private AnimalModel animal;
    private CommentModel parentComment;
    private List<CommentModel> replies;
}
