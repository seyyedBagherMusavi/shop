package com.kahkeshan.service;

import com.kahkeshan.entities.User;

public interface UserService {
    User findUserByUsername(String username);
}
