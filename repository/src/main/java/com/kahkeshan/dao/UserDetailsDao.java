package com.kahkeshan.dao;


import com.kahkeshan.entities.User;

public interface UserDetailsDao {
    User findUserByUsername(String username);
}
