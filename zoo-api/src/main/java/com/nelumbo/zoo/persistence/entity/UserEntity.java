package com.nelumbo.zoo.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String lastname;
    @Column(length = 10, unique = true)
    private String dni;
    @Column(length = 10)
    private String phone;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String token;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}