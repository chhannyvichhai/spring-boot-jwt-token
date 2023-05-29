package com.chhai.friendlyjwt.service.serviceImpl;

import com.chhai.friendlyjwt.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailsService {
    UserRepository userRepository;
    public UserDetailServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.chhai.friendlyjwt.model.User authenticatedUser = userRepository.findUserByName(username).stream().findFirst().orElse(null);
        if (authenticatedUser == null){
            throw new UsernameNotFoundException("AuthenticationUser doesn't exist");
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(authority);

        UserDetails user = org.springframework.security.core.userdetails.User.builder()
                .username(authenticatedUser.getUsername())
                .password(authenticatedUser.getPassword())
                .authorities(authorities)
                .build();
        return user;
    }
}
