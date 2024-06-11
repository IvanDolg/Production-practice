package com.progtammingtechie.productionpractice.service;

import com.progtammingtechie.productionpractice.dto.UserDto;
import com.progtammingtechie.productionpractice.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userid);
    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);
    void deleteUser(Long userid);
}
