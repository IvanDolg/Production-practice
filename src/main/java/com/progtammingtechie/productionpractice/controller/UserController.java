package com.progtammingtechie.productionpractice.controller;

import com.progtammingtechie.productionpractice.dto.UserDto;
import com.progtammingtechie.productionpractice.entity.User;
import com.progtammingtechie.productionpractice.exception.ErrorDetails;
import com.progtammingtechie.productionpractice.exception.RecurseNotFoundException;
import com.progtammingtechie.productionpractice.service.UserService;
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
        name = "Crud rest apis for user Resource",
        description = "Crud rest apis - Create user, Update user, Get user, Get all users, Delete user"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Operation(
            summary = "Create user rest api",
            description = "Create user rest api is used to save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new  ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get user by ID rest api",
            description = "Get user by ID rest api is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userid) {
        return new  ResponseEntity<>(userService.getUserById(userid), HttpStatus.OK);
    }

    @Operation(
            summary = "Get all users rest api",
            description = "Get all users rest api is used to get a all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new  ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @Operation(
            summary = "Update user rest api",
            description = "Update user rest api is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user,
                                              @PathVariable("id") Long userid) {
        user.setId(userid);
        return new  ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @Operation(
            summary = "Delete user rest api",
            description = "Delete user rest api is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userid) {
        userService.deleteUser(userid);
        return new  ResponseEntity<>("Student " + userid + " was deleted", HttpStatus.OK);
    }
}
