package com.progtammingtechie.productionpractice.service.impl;

import com.progtammingtechie.productionpractice.dto.UserDto;
import com.progtammingtechie.productionpractice.entity.User;
import com.progtammingtechie.productionpractice.mapper.UserMapper;
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
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userid) {
        Optional<User> userOptional = userRepository.findById(userid);
        User user = userOptional.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existUser = userRepository.findById(user.getId()).get();
        existUser.setFirstName(user.getFirstName());
        existUser.setSecondName(user.getSecondName());
        existUser.setEmail(user.getEmail());
        return UserMapper.mapToUserDto(userRepository.save(existUser));
    }

    @Override
    public void deleteUser(Long userid) {
        userRepository.deleteById(userid);
    }
}
