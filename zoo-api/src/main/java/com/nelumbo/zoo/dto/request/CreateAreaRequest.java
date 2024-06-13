package com.nelumbo.zoo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAreaRequest {
    @NotBlank(message = "The name cannot be empty")
    private String name;
}
