package com.progtammingtechie.productionpractice.controller;

import com.progtammingtechie.productionpractice.entity.User;
import com.progtammingtechie.productionpractice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new  ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userid) {
        return new  ResponseEntity<>(userService.getUserById(userid), HttpStatus.OK);
    }
}
