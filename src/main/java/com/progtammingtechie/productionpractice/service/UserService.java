package com.progtammingtechie.productionpractice.service;

import com.progtammingtechie.productionpractice.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userid);
}
