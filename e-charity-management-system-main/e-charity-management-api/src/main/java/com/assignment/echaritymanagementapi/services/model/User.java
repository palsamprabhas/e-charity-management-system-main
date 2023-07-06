package com.assignment.echaritymanagementapi.services.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String username;
    private String password;
    private String role;

    private String name;
    private String email;

    private String phoneNumber;

    private String address;

    private String ngoType;

    private String ngoShortDescription;

    private String profilePicFileId;

    private String status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgoType() {
        return ngoType;
    }

    public void setNgoType(String ngoType) {
        this.ngoType = ngoType;
    }

    public String getNgoShortDescription() {
        return ngoShortDescription;
    }

    public void setNgoShortDescription(String ngoShortDescription) {
        this.ngoShortDescription = ngoShortDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfilePicFileId() {
        return profilePicFileId;
    }

    public void setProfilePicFileId(String profilePicFileId) {
        this.profilePicFileId = profilePicFileId;
    }
}
