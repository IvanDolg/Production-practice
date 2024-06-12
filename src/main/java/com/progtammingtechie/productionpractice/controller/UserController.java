package com.progtammingtechie.productionpractice.controller;

import com.progtammingtechie.productionpractice.dto.UserDto;
import com.progtammingtechie.productionpractice.entity.User;
import com.progtammingtechie.productionpractice.exception.ErrorDetails;
import com.progtammingtechie.productionpractice.exception.RecurseNotFoundException;
import com.progtammingtechie.productionpractice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new  ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userid) {
        return new  ResponseEntity<>(userService.getUserById(userid), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new  ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user,
                                              @PathVariable("id") Long userid) {
        user.setId(userid);
        return new  ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userid) {
        userService.deleteUser(userid);
        return new  ResponseEntity<>("Student " + userid + " was deleted", HttpStatus.OK);
    }

//    @ExceptionHandler(RecurseNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(RecurseNotFoundException exception,
//                                                                        WebRequest webRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND");
//        return new  ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
