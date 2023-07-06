package com.assignment.echaritymanagementapi.services;

import com.assignment.echaritymanagementapi.services.model.GeneralResponse;
import com.assignment.echaritymanagementapi.services.model.User;
import com.assignment.echaritymanagementapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    void addUser() {
        User user = new User();

        when(userRepository.save(user)).thenReturn(user);

        User response = userService.addUser(user);

        assertEquals(response, user);
    }

    @Test
    void loginUser() {
        User user = new User();

        when(userRepository.findByUsernameAndPasswordAndStatus(user.getUsername(), user.getPassword(), "APPROVED")).thenReturn(Optional.of(user));

        Optional<User> response = userService.loginUser(user);

        assertEquals(user, response.get());
    }

    @Test
    void getUserByName() {
        User user = new User();

        when(userRepository.findById("username")).thenReturn(Optional.of(user));

        Optional<User> response = userService.getUserByName("username");

        assertEquals(user, response.get());
    }

    @Test
    void getAllUsers() {
        List<User> users = mock(List.class);

        when(userRepository.findAll()).thenReturn(users);

        List<User> response = userService.getAllUsers();

        assertEquals(response, users);
    }

    @Test
    void getAllUsersByStatus() {
        List<User> users = mock(List.class);

        when(userRepository.findAllByStatus("APPROVED")).thenReturn(users);

        List<User> response = userService.getAllUsersByStatus("APPROVED");

        assertEquals(response, users);
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setName("username");

        when(userRepository.findById(user.getUsername())).thenReturn(Optional.of(user));

        GeneralResponse generalResponse = userService.updateUser(user);
        when(userRepository.save(user)).thenReturn(user);

        assertNotNull(generalResponse);
        assertEquals(generalResponse.getMessage(), "updated user successfully");
    }

    @Test
    void updateUserStatus() {
        User user = new User();
        user.setName("username");

        when(userRepository.findById("username")).thenReturn(Optional.of(user));

        GeneralResponse generalResponse = userService.updateUserStatus("username", "APPROVED");
        when(userRepository.save(user)).thenReturn(user);

        assertNotNull(generalResponse);
        assertEquals(generalResponse.getMessage(), "updated user status successfully");
    }

    @Test
    void deleteUserByName() {
        doNothing().when(userRepository).deleteById("username");

        boolean response = userService.deleteUserByName("username");

        assertTrue(response);
    }
}