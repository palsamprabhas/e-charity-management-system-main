package com.assignment.echaritymanagementapi.helper;

import com.assignment.echaritymanagementapi.services.UserService;
import com.assignment.echaritymanagementapi.services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitConfigLoader implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Value("${admin.user}")
    String adminUser;

    @Value("${admin.password}")
    String adminPassword;


    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername(adminUser);
        user.setPassword(adminPassword);
        user.setRole("ADMIN");
        user.setName("admin");
        userService.addUser(user);
    }
}
