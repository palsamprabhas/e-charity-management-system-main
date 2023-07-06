package com.assignment.echaritymanagementapi.controller;


import com.assignment.echaritymanagementapi.services.UserService;
import com.assignment.echaritymanagementapi.services.model.GeneralResponse;
import com.assignment.echaritymanagementapi.services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User userRequest) {
        return userService.addUser(userRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User userRequest) {
        Optional<User> optionalUser = userService.loginUser(userRequest);

        if (optionalUser.isPresent()) {
            return new ResponseEntity<User>(
                    optionalUser.get(),
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<User>(
                HttpStatus.NOT_FOUND
        );
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity(
                users,
                HttpStatus.OK
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<User>> getAllUsersByStatus(@PathVariable String status) {
        List<User> users = userService.getAllUsersByStatus(status);
        return new ResponseEntity(
                users,
                HttpStatus.OK
        );
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByName(@PathVariable String username) {
        Optional<User> optionalUser = userService.getUserByName(username);

        if (optionalUser.isPresent()) {
            return new ResponseEntity<User>(
                    optionalUser.get(),
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<User>(
                HttpStatus.NOT_FOUND
        );
    }

    @PutMapping("/{username}/{status}")
    public ResponseEntity<GeneralResponse> updateUserStatus(@PathVariable String username, @PathVariable String status) {
        GeneralResponse generalResponse = userService.updateUserStatus(username, status);
        return new ResponseEntity(
                generalResponse,
                HttpStatus.OK
        );

    }

    @PutMapping
    public ResponseEntity<GeneralResponse> updateUser(@RequestBody User user) {
        GeneralResponse generalResponse = userService.updateUser(user);
        return new ResponseEntity(
                generalResponse,
                HttpStatus.OK
        );

    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUserByName(@PathVariable String username) {
        userService.deleteUserByName(username);
        return new ResponseEntity<>(
                "User deleted successfully",
                HttpStatus.OK
        );
    }

}