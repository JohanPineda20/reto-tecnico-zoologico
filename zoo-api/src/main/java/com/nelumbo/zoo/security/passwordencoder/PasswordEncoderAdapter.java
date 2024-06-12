package com.nelumbo.zoo.security.passwordencoder;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class PasswordEncoderAdapter implements IPasswordEncoder {

    private final PasswordEncoder passwordEncoder;
    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
