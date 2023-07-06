package com.assignment.echaritymanagementapi.services;

import com.assignment.echaritymanagementapi.repository.UserRepository;
import com.assignment.echaritymanagementapi.services.model.GeneralResponse;
import com.assignment.echaritymanagementapi.services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User addUser(User userRequest) {
        if ("NGO".equalsIgnoreCase(userRequest.getRole())) {
            userRequest.setStatus("PENDING");
        } else {
            userRequest.setStatus("APPROVED");
        }
        User userResponse = userRepository.save(userRequest);
        return userResponse;
    }

    public Optional<User> loginUser(User user) {
        return userRepository.findByUsernameAndPasswordAndStatus(user.getUsername(), user.getPassword(), "APPROVED");
    }

    public Optional<User> getUserByName(String username) {
        Optional<User> optionalUser = userRepository.findById(username);

        return optionalUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllUsersByStatus(String status) {
        return userRepository.findAllByStatus(status);
    }

    public GeneralResponse updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getUsername());
        if (!optionalUser.isPresent()) {
            return new GeneralResponse("user not found");
        }
        User findUser = optionalUser.get();
        findUser.setName(user.getName());
        findUser.setPhoneNumber(user.getPhoneNumber());
        findUser.setEmail(user.getEmail());
        userRepository.save(findUser);
        return new GeneralResponse("updated user successfully");
    }

    public GeneralResponse updateUserStatus(String username, String status) {
        Optional<User> optionalUser = userRepository.findById(username);
        if (!optionalUser.isPresent()) {
            return new GeneralResponse("user not found");
        }
        User user = optionalUser.get();
        user.setStatus(status);
        userRepository.save(user);
        return new GeneralResponse("updated user status successfully");
    }

    public boolean deleteUserByName(String username) {
        userRepository.deleteById(username);
        return true;
    }
}
