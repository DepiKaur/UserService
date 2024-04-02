package com.hobbyprojects.userservice.api.controller;

import com.hobbyprojects.userservice.api.dto.UserDto;
import com.hobbyprojects.userservice.api.mapper.DtoToEntityMapper;
import com.hobbyprojects.userservice.api.mapper.EntityToDtoMapper;
import com.hobbyprojects.userservice.entity.User;
import com.hobbyprojects.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>UserController</h2>
 * @date 2024-04-02
 */

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return allUsers.stream()
                .map(user -> EntityToDtoMapper.mapToUserDto(user))
                .toList();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {

        User user = DtoToEntityMapper.mapToUser(userDto);          // get user from userDto
        User savedUser = userService.createUser(user);

        return EntityToDtoMapper.mapToUserDto(savedUser);     // get userDto from user
    }

    @GetMapping("/users/{id}")
    public Optional<UserDto> getUserById(@PathVariable("id") Long id) {
        Optional<User> opUser = userService.getUserById(id);
        if (opUser.isPresent()) {
            User user = opUser.get();
            return Optional.ofNullable(EntityToDtoMapper.mapToUserDto(user));
        } else {
            return Optional.empty();
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable("id") Long id,
                           @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }
}
