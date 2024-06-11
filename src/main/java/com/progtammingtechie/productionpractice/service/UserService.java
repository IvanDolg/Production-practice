package com.progtammingtechie.productionpractice.service;

import com.progtammingtechie.productionpractice.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userid);
    List<User> getAllUsers();

    User updateUser(User user);
    void deleteUser(Long userid);
}
