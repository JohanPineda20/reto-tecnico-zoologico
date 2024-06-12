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
import com.nelumbo.zoo.service.IAnimalService;
import com.nelumbo.zoo.service.IAreaService;
import com.nelumbo.zoo.service.ICommentService;
import com.nelumbo.zoo.service.IMetricService;
import com.nelumbo.zoo.service.ISpecieService;
import com.nelumbo.zoo.service.IUserService;
import com.nelumbo.zoo.service.impl.AnimalUseCase;
import com.nelumbo.zoo.service.impl.AreaUseCase;
import com.nelumbo.zoo.service.impl.CommentUseCase;
import com.nelumbo.zoo.service.impl.MetricUseCase;
import com.nelumbo.zoo.service.impl.SpecieUseCase;
import com.nelumbo.zoo.service.impl.UserUseCase;


@Configuration
public class BeansConfig {

    @Bean
    public IUserPersistence userPersistence(UserRepository userRepository,
                                            UserEntityMapper userEntityMapper){
        return new UserPostgresqlAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IRolePersistence rolePersistence(RoleRepository roleRepository,
                                            RoleEntityMapper roleEntityMapper){
        return new RolePostgresqlAdapter(roleRepository, roleEntityMapper);
    }
   
    @Bean
    public IPasswordEncoder passwordEncoderPort(PasswordEncoder passwordEncoder){
        return new PasswordEncoderAdapter(passwordEncoder);
    }

    @Bean
    public IAuthInformation authInformation(){
        return new AuthInformationAdapter();
    }

    @Bean
    public IUserService userService(IUserPersistence userPersistence,
                                            IRolePersistence rolePersistence,
                                            IPasswordEncoder passwordEncoder){
        return new UserUseCase(userPersistence, rolePersistence, passwordEncoder);
    }

    @Bean
    public IAreaService areaService(){
        return new AreaUseCase();
    }

    @Bean
    public ISpecieService specieService(){
        return new SpecieUseCase();
    }

    @Bean
    public IAnimalService animalService(){
        return new AnimalUseCase();
    }

    @Bean
    public ICommentService commentService(){
        return new CommentUseCase();
    }
    
    @Bean
    public IMetricService metricService(){
        return new MetricUseCase();
    }
}