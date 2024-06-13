package com.nelumbo.zoo.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CreateAnimalRequest {
    @NotBlank(message = "The name cannot be empty")
    private String name;
}
