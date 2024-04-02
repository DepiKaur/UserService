package com.hobbyprojects.userservice.api.mapper;

import com.hobbyprojects.userservice.api.dto.UserDto;
import com.hobbyprojects.userservice.entity.User;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>EntityToDtoMapper</h2>
 * @date 2024-04-02
 */
public class EntityToDtoMapper {

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .creationDate(user.getCreationDate())
                .build();
    }
}
