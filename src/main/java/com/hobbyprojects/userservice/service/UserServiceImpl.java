package com.hobbyprojects.userservice.service;

import com.hobbyprojects.userservice.model.User;
import com.hobbyprojects.userservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>UserServiceImpl</h2>
 * @date 2024-04-02
 */

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
