package com.nelumbo.zoo.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateSpecieRequest {
    @NotBlank(message = "The name cannot be empty")
    private String name;
    @NotNull(message = "The area_id is required")
    @Min(value = 1, message = "The area_id must be a positive number")
    private Long areaId;
}
