package com.kahkeshan.service;

import com.kahkeshan.dao.UserDetailsDao;
import com.kahkeshan.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDetailsDao userDetailsDao;

    @Transactional
    @Override
    public User findUserByUsername(String username) {
        return userDetailsDao.findUserByUsername(username);
    }
}
