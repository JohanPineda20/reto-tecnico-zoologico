package com.nelumbo.zoo.security.userdetails;

import com.nelumbo.zoo.persistence.entity.UserEntity;
import com.nelumbo.zoo.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User with email: "+ username +" not found"));
        return new UserDetailsImpl(userEntity);
    }
}
