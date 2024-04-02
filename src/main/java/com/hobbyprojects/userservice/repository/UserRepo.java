package com.hobbyprojects.userservice.repository;

import com.hobbyprojects.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>UserRepo</h2>
 * @date 2024-04-02
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
