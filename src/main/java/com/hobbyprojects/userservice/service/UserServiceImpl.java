package com.hobbyprojects.userservice.service;

import com.hobbyprojects.userservice.model.PatchUserRequest;
import com.hobbyprojects.userservice.model.User;
import com.hobbyprojects.userservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User getUserById(String userId) {
        User user = null;
        Optional<User> opUser = Optional.ofNullable(userId)
                .map(u -> Long.valueOf(userId))
                .map(userRepo::findById)
                .orElseThrow();

        if (opUser.isPresent()) {
            user = opUser.get();
        }
        return user;
    }

    @Override
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(String userId) {

        User user = getUserById(userId);
        userRepo.delete(user);

        /*
        Optional<User> opUser = userRepo.findById(Long.valueOf(userId));
        if (opUser.isPresent()) {
            User desiredUser = opUser.get();
            userRepo.delete(desiredUser);
        }
         */
    }

    @Override
    public void updateUser(String userId, PatchUserRequest request) {
        User user = getUserById(userId);
        if(request.getFirstName() != null) {
            user.setFirstName(request.getFirstName());
        }

        if(request.getLastName() != null) {
            user.setLastName(request.getLastName());
        }

        if(request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }

        userRepo.save(user);
    }
}
