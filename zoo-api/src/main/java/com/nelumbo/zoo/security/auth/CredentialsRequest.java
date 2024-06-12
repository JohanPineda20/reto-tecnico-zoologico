package com.nelumbo.zoo.security.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CredentialsRequest {
    private String email;
    private String password;
}
