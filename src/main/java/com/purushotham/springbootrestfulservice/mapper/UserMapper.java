package com.purushotham.springbootrestfulservice.mapper;

import com.purushotham.springbootrestfulservice.dto.UserDTO;
import com.purushotham.springbootrestfulservice.entity.User;

public class UserMapper {
    public static UserDTO mapToUserDto(User user){
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
    public static User mapToUser(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail());
    }
}
