package com.nelumbo.zoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nelumbo.zoo.persistence.impl.RolePostgresqlAdapter;
import com.nelumbo.zoo.mappers.entity.RoleEntityMapper;
import com.nelumbo.zoo.mappers.entity.UserEntityMapper;
import com.nelumbo.zoo.persistence.IRolePersistence;
import com.nelumbo.zoo.persistence.IUserPersistence;
import com.nelumbo.zoo.persistence.impl.UserPostgresqlAdapter;
import com.nelumbo.zoo.persistence.repository.RoleRepository;
import com.nelumbo.zoo.persistence.repository.UserRepository;
import com.nelumbo.zoo.security.auth.authinformation.AuthInformationAdapter;
import com.nelumbo.zoo.security.auth.authinformation.IAuthInformation;
import com.nelumbo.zoo.security.passwordencoder.IPasswordEncoder;
import com.nelumbo.zoo.security.passwordencoder.PasswordEncoderAdapter;
import com.nelumbo.zoo.service.IUserService;
import com.nelumbo.zoo.service.impl.UserUseCase;


@Configuration
public class BeansConfig {
    @Bean
    public IUserPersistence userPersistencePort(UserRepository userRepository,
                                                UserEntityMapper userEntityMapper){
        return new UserPostgresqlAdapter(userRepository, userEntityMapper);
    }
    @Bean
    public IRolePersistence rolePersistencePort(RoleRepository roleRepository,
                                                RoleEntityMapper roleEntityMapper){
        return new RolePostgresqlAdapter(roleRepository, roleEntityMapper);
    }
   
    @Bean
    public IPasswordEncoder passwordEncoderPort(PasswordEncoder passwordEncoder){
        return new PasswordEncoderAdapter(passwordEncoder);
    }
    @Bean
    public IAuthInformation authenticationInfoPort(){
        return new AuthInformationAdapter();
    }

    @Bean
    public IUserService userServicePort(IUserPersistence userPersistence,
                                            IRolePersistence rolePersistence,
                                            IPasswordEncoder passwordEncoder){
        return new UserUseCase(userPersistence, rolePersistence, passwordEncoder);
    }

}
