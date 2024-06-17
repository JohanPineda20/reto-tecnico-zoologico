package com.nelumbo.zoo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nelumbo.zoo.persistence.entity.AnimalEntity;
import com.nelumbo.zoo.persistence.entity.CommentEntity;
import com.nelumbo.zoo.persistence.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CommentResponse {
    private Long id;
    String body;
    LocalDateTime createdAt;
    List<CommentResponse> replies;
}
