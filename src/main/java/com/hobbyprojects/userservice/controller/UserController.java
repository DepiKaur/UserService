package com.hobbyprojects.userservice.controller;

import com.hobbyprojects.userservice.model.User;
import com.hobbyprojects.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>UserController</h2>
 * @date 2024-04-02
 */

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
