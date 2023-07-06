package com.assignment.echaritymanagementapi.controller;

import com.assignment.echaritymanagementapi.services.UserService;
import com.assignment.echaritymanagementapi.services.model.GeneralResponse;
import com.assignment.echaritymanagementapi.services.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserRestControllerTest {
    @InjectMocks
    UserRestController userRestController;

    @Mock
    UserService userService;

    @Test
    void addUser() {
        User user = new User();

        when(userService.addUser(user)).thenReturn(user);

        User response = userRestController.addUser(user);

        assertEquals(response, user);
    }

    @Test
    void loginUser() {
        User user = new User();

        when(userService.loginUser(user)).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userRestController.loginUser(user);

        assertEquals(response.getBody(), user);
    }

    @Test
    void loginUserWhenUserNotFound() {
        User user = new User();

        when(userService.loginUser(user)).thenReturn(Optional.empty());

        ResponseEntity<User> response = userRestController.loginUser(user);

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void getAllUsers() {
        List<User> users = mock(List.class);

        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<User>> response = userRestController.getAllUsers();

        assertEquals(response.getBody(), users);
    }

    @Test
    void getAllUsersByStatus() {
        List<User> users = mock(List.class);

        when(userService.getAllUsersByStatus("APPROVED")).thenReturn(users);

        ResponseEntity<List<User>> response = userRestController.getAllUsersByStatus("APPROVED");

        assertEquals(response.getBody(), users);
    }

    @Test
    void getUserByName() {
        User user = mock(User.class);

        when(userService.getUserByName("username")).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userRestController.getUserByName("username");

        assertEquals(response.getBody(), user);
    }

    @Test
    void getUserByNameWhenUserNotFound() {
        User user = mock(User.class);

        when(userService.getUserByName("username")).thenReturn(Optional.empty());

        ResponseEntity<User> response = userRestController.getUserByName("username");

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void updateUserStatus() {
        GeneralResponse generalResponse = new GeneralResponse("user status updated successfully");

        when(userService.updateUserStatus("username", "APPROVED")).thenReturn(generalResponse);

        ResponseEntity<GeneralResponse> response = userRestController.updateUserStatus("username", "APPROVED");

        assertEquals(response.getBody(), generalResponse);
    }

    @Test
    void updateUser() {
        User user = mock(User.class);
        GeneralResponse generalResponse = new GeneralResponse("user updated successfully");

        when(userService.updateUser(user)).thenReturn(generalResponse);

        ResponseEntity<GeneralResponse> response = userRestController.updateUser(user);

        assertEquals(response.getBody(), generalResponse);
    }

    @Test
    void deleteUserByName() {
       when(userService.deleteUserByName("username")).thenReturn(true);

        ResponseEntity<String> response = userRestController.deleteUserByName("username");

        assertEquals(response.getBody(), "User deleted successfully");
    }
}