package com.nelumbo.zoo.persistence.repository;

import com.nelumbo.zoo.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
    UserEntity findByToken(String token);
}
