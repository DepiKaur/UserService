package com.hobbyprojects.userservice.api.mapper;

import com.hobbyprojects.userservice.api.dto.UserDto;
import com.hobbyprojects.userservice.entity.User;

import java.time.LocalDateTime;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>DtoToEntityMapper</h2>
 * @date 2024-04-02
 */
public class DtoToEntityMapper {

    public static User mapToUser(UserDto userDto) {

        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .creationDate(LocalDateTime.now())
                .build();
    }
}
