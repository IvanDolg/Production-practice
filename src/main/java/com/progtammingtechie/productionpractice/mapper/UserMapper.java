package com.progtammingtechie.productionpractice.mapper;

import com.progtammingtechie.productionpractice.dto.UserDto;
import com.progtammingtechie.productionpractice.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getEmail()
        );
        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getSecondName(),
                userDto.getEmail()
        );
        return user;
    }
}
