package com.purushotham.springbootrestfulservice.service.impl;

import com.purushotham.springbootrestfulservice.dto.UserDTO;
import com.purushotham.springbootrestfulservice.entity.User;
import com.purushotham.springbootrestfulservice.mapper.AutoUserMapper;
import com.purushotham.springbootrestfulservice.mapper.UserMapper;
import com.purushotham.springbootrestfulservice.repository.UserRepository;
import com.purushotham.springbootrestfulservice.service.UserService;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
   // private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //Convert UserDTO to User JPA Entity
        User user = AutoUserMapper.MAPPER.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        //Convert User JPA entity to UserDto
        UserDTO savedUserDTO = AutoUserMapper.MAPPER.mapToUserDTO(savedUser);
        return savedUserDTO;

        /*//Convert UserDTO to User JPA Entity
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        //Convert User JPA entity to UserDto
        UserDTO savedUserDTO = modelMapper.map(savedUser, UserDTO.class);
        return savedUserDTO;*/
        /*//Convert UserDTO to User JPA Entity
        User user = UserMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        //Convert User JPA entity to UserDto
        UserDTO savedUserDTO = UserMapper.mapToUserDto(savedUser);
        return savedUserDTO;*/
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return AutoUserMapper.MAPPER.mapToUserDTO(user);
        /*Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return modelMapper.map(user, UserDTO.class);*/
    }

    @Override
    public List<UserDTO> getAllUsers() {
        /*List<User> users =  userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());*/
       /* List<User> users =  userRepository.findAll();
        return users.stream().map((user) -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());*/
        List<User> users =  userRepository.findAll();
        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId()).get();
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return AutoUserMapper.MAPPER.mapToUserDTO(updatedUser);

        /*User existingUser = userRepository.findById(userDTO.getId()).get();
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDTO.class);*/
        /*User existingUser = userRepository.findById(userDTO.getId()).get();
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);*/
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
