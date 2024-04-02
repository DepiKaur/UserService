package com.hobbyprojects.userservice.service;

import com.hobbyprojects.userservice.api.dto.UserDto;
import com.hobbyprojects.userservice.constants.AppConstants;
import com.hobbyprojects.userservice.entity.User;
import com.hobbyprojects.userservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>UserService</h2>
 * @date 2024-04-02
 */

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepo.findById(userId);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUserById(Long userId) {
        Optional<User> opUser = getUserById(userId);
        if (opUser.isPresent()) {
            User user = opUser.get();
            userRepo.delete(user);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void update(Long userId, UserDto userDto) {
        validatePatchRequest(userDto);
        updateUser(userId, userDto);
    }

    private void validatePatchRequest(UserDto userDto) {
        if (userDto.getFirstName() != null && userDto.getFirstName().isBlank()) {
            throw new IllegalArgumentException("First name can not be blank");
        }

        if (userDto.getLastName() != null && userDto.getLastName().isBlank()) {
            throw new IllegalArgumentException("Last name can not be blank");
        }

        if (userDto.getEmail() != null && userDto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email can not be blank");
        }

        //verify regular expression for email
        if (userDto.getEmail() != null && !Pattern.matches(AppConstants.EMAIL_REGEX, userDto.getEmail())) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    private void updateUser(Long userId, UserDto userDto) {
        Optional<User> opUser = getUserById(userId);

        if (opUser.isPresent()) {
            User user = opUser.get();

             if (userDto.getFirstName() != null) {
                 user.setFirstName(userDto.getFirstName());
             }

             if (userDto.getLastName() != null) {
                 user.setLastName(userDto.getLastName());
             }

             if (userDto.getEmail() != null) {
                 user.setEmail(userDto.getEmail());
             }

             userRepo.save(user);
        }
    }
}
