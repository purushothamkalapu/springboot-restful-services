package com.purushotham.springbootrestfulservice.service;


import com.purushotham.springbootrestfulservice.dto.UserDTO;
import com.purushotham.springbootrestfulservice.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(Long userId);
}
