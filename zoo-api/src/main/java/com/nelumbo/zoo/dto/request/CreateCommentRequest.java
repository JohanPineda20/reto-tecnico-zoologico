package com.nelumbo.zoo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentRequest {
    @NotBlank(message = "body cannot be empty")
    @Size(max = 250, message = "body cannot be more than 250 characters")
    private String body;
}
