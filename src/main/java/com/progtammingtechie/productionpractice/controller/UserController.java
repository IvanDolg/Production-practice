package com.progtammingtechie.productionpractice.controller;

import com.progtammingtechie.productionpractice.entity.User;
import com.progtammingtechie.productionpractice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new  ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,
                                           @PathVariable("id") Long userid) {
        user.setId(userid);
        return new  ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userid) {
        userService.deleteUser(userid);
        return new  ResponseEntity<>("Student " + userid + " was deleted", HttpStatus.OK);
    }

}
