package com.chhai.friendlyjwt.service.serviceImpl;

import com.chhai.friendlyjwt.model.User;
import com.chhai.friendlyjwt.repository.UserRepository;
import com.chhai.friendlyjwt.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findUserByName(String username) {
        return userRepository.findUserByName(username);
    }
}
