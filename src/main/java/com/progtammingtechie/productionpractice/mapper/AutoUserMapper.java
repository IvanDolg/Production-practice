package com.progtammingtechie.productionpractice.mapper;

import com.progtammingtechie.productionpractice.dto.UserDto;
import com.progtammingtechie.productionpractice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
