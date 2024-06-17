package com.nelumbo.zoo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private String phone;
    private String email;
    private String role;
}
