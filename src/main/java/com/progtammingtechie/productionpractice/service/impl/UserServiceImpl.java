package com.progtammingtechie.productionpractice.service.impl;

import com.progtammingtechie.productionpractice.entity.User;
import com.progtammingtechie.productionpractice.repository.UserRepository;
import com.progtammingtechie.productionpractice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userid) {
        Optional<User> user = userRepository.findById(userid);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existUser = userRepository.findById(user.getId()).get();
        existUser.setFirstName(user.getFirstName());
        existUser.setSecondName(user.getSecondName());
        existUser.setEmail(user.getEmail());
        return userRepository.save(existUser);
    }

    @Override
    public void deleteUser(Long userid) {
        userRepository.deleteById(userid);
    }
}
