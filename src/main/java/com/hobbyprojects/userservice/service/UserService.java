package com.hobbyprojects.userservice.service;

import com.hobbyprojects.userservice.model.User;

import java.util.List;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>UserService</h2>
 * @date 2024-04-02
 */
public interface UserService {
    List<User> getAllUsers();
}
