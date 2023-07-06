package com.assignment.echaritymanagementapi.model;

import com.assignment.echaritymanagementapi.services.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@gmail.com");
        user.setPhoneNumber("4785697842");
        user.setStatus("APPROVED");
        user.setAddress("France");
        user.setRole("NGO");
        user.setNgoShortDescription("ngo description");
        user.setProfilePicFileId("profile-pic-id");
        user.setPassword("password");
        user.setNgoType("ngotype");
        user.setName("test user");

        assertEquals("testuser", user.getUsername());
        assertEquals("test@gmail.com", user.getEmail());
        assertEquals("4785697842", user.getPhoneNumber());
        assertEquals("APPROVED", user.getStatus());
        assertEquals("France", user.getAddress());
        assertEquals("NGO", user.getRole());
        assertEquals("ngo description", user.getNgoShortDescription());
        assertEquals("profile-pic-id", user.getProfilePicFileId());
        assertEquals("password", user.getPassword());
        assertEquals("ngotype", user.getNgoType());
        assertEquals("test user", user.getName());

    }

}