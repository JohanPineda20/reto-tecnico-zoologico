package com.nelumbo.zoo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nelumbo.zoo.persistence.impl.AnimalPostgresqlAdapter;
import com.nelumbo.zoo.persistence.impl.AreaPostgresqlAdapter;
import com.nelumbo.zoo.persistence.impl.CommentPostgresqlAdapter;
import com.nelumbo.zoo.persistence.impl.RolePostgresqlAdapter;
import com.nelumbo.zoo.persistence.impl.SpeciePostgresqlAdapter;
import com.nelumbo.zoo.mappers.entity.AnimalEntityMapper;
import com.nelumbo.zoo.mappers.entity.AreaEntityMapper;
import com.nelumbo.zoo.mappers.entity.CommentEntityMapper;
import com.nelumbo.zoo.mappers.entity.RoleEntityMapper;
import com.nelumbo.zoo.mappers.entity.SpecieEntityMapper;
import com.nelumbo.zoo.mappers.entity.UserEntityMapper;
import com.nelumbo.zoo.persistence.IAnimalPersistence;
import com.nelumbo.zoo.persistence.IAreaPersistence;
import com.nelumbo.zoo.persistence.ICommentPersistence;
import com.nelumbo.zoo.persistence.IRolePersistence;
import com.nelumbo.zoo.persistence.ISpeciePersistence;
import com.nelumbo.zoo.persistence.IUserPersistence;
import com.nelumbo.zoo.persistence.impl.UserPostgresqlAdapter;
import com.nelumbo.zoo.persistence.repository.AnimalRepository;
import com.nelumbo.zoo.persistence.repository.AreaRepository;
import com.nelumbo.zoo.persistence.repository.CommentRepository;
import com.nelumbo.zoo.persistence.repository.RoleRepository;
import com.nelumbo.zoo.persistence.repository.SpecieRepository;
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
import com.nelumbo.zoo.service.impl.SpecieUseCase;
import com.nelumbo.zoo.service.impl.MetricUseCase;
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
    public IAreaPersistence areaPersistence(AreaRepository areaRepository,
                                            AreaEntityMapper areaEntityMapper){
        return new AreaPostgresqlAdapter(areaRepository, areaEntityMapper);
    }

    @Bean
    public ISpeciePersistence speciePersistence(SpecieRepository specieRepository,
                                                SpecieEntityMapper specieEntityMapper){
        return new SpeciePostgresqlAdapter(specieRepository, specieEntityMapper);
    }

    @Bean
    public IAnimalPersistence animalPersistence(AnimalRepository animalRepository,
                                                AnimalEntityMapper animalEntityMapper){
        return new AnimalPostgresqlAdapter(animalRepository, animalEntityMapper);
    }
   
    @Bean
    public ICommentPersistence commentPersistence(CommentRepository commentRepository,
                                                  CommentEntityMapper commentEntityMapper){
        return new CommentPostgresqlAdapter(commentRepository, commentEntityMapper);
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
    public IAreaService areaService(IAreaPersistence areaPersistence){
        return new AreaUseCase(areaPersistence);
    }

    @Bean
    public ISpecieService specieService(ISpeciePersistence speciePersistence,
                                        IAreaService areaService){
        return new SpecieUseCase(speciePersistence, areaService);
    }

    @Bean
    public IAnimalService animalService(IAnimalPersistence animalPersistence,
                                        ISpecieService specieService){
        return new AnimalUseCase(animalPersistence, specieService);
    }

    @Bean
    public ICommentService commentService(ICommentPersistence commentPersistence){
        return new CommentUseCase(commentPersistence);
    }

    @Bean
    public IMetricService metricService(){
        return new MetricUseCase();
    }
}