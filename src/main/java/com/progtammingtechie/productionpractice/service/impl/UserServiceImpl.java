package com.progtammingtechie.productionpractice.service.impl;

import com.progtammingtechie.productionpractice.dto.UserDto;
import com.progtammingtechie.productionpractice.entity.User;
import com.progtammingtechie.productionpractice.mapper.AutoUserMapper;
import com.progtammingtechie.productionpractice.mapper.UserMapper;
import com.progtammingtechie.productionpractice.repository.UserRepository;
import com.progtammingtechie.productionpractice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        //User user = UserMapper.mapToUser(userDto);
        //User user = modelMapper.map(userDto, User.class);

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);

       //UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        // UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userid) {
        Optional<User> userOptional = userRepository.findById(userid);
        User user = userOptional.get();

        //return UserMapper.mapToUserDto(user);
        //return modelMapper.map(user, UserDto.class);

        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        //return users.stream().map(UserMapper::mapToUserDto).toList();
       //return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).toList();

        return users.stream().map(AutoUserMapper.MAPPER::mapToUserDto).toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existUser = userRepository.findById(user.getId()).get();
        existUser.setFirstName(user.getFirstName());
        existUser.setSecondName(user.getSecondName());
        existUser.setEmail(user.getEmail());

        //return UserMapper.mapToUserDto(userRepository.save(existUser));
        //return modelMapper.map(userRepository.save(existUser), UserDto.class);

        return AutoUserMapper.MAPPER.mapToUserDto(userRepository.save(existUser));
    }

    @Override
    public void deleteUser(Long userid) {
        userRepository.deleteById(userid);
    }
}
