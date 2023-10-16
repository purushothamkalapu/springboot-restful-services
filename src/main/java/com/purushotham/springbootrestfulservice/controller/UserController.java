package com.purushotham.springbootrestfulservice.controller;

import com.purushotham.springbootrestfulservice.dto.UserDTO;
import com.purushotham.springbootrestfulservice.entity.User;
import com.purushotham.springbootrestfulservice.exception.ErrorDetails;
import com.purushotham.springbootrestfulservice.exception.ResourceNotFoundException;
import com.purushotham.springbootrestfulservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
@Tag(
        name = "CRUD REST APIs User Resource",
        description = "CRUD REST APIs Create , Update, GET by user id, Get All , Delete User Resource"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping
    @Operation(
            summary="Create User REST API",
            description="Create User REST API is used to Save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description="HTTP Status 201 Created"
    )
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user){
        UserDTO savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    @Operation(
            summary="Get User by ID REST API",
            description="Get User By ID REST API i used to get a single user from database"
    )
    @ApiResponse(
            responseCode = "200",
            description="HTTP Status 200 Successfully"
    )
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId){
        UserDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    @Operation(
            summary="Get All Users  REST API",
            description="Get All Users  REST API i used to get a single user from database"
    )
    @ApiResponse(
            responseCode = "200",
            description="HTTP Status 200 Successfully"
    )
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<UserDTO> updateUser(@Valid @PathVariable("id") Long userId,
                                           @RequestBody UserDTO userDTO){
        userDTO.setId(userId);
        UserDTO updatedUser = userService.updateUser(userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

   /* @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }*/
}
