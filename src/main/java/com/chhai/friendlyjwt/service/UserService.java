package com.chhai.friendlyjwt.service;

import com.chhai.friendlyjwt.model.User;
import java.util.List;

public interface UserService {

    List<User> findUserByName(String username);
}
