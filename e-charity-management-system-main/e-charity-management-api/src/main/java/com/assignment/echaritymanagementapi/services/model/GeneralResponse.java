package com.assignment.echaritymanagementapi.services.model;

public class GeneralResponse {
    private String message;

    public GeneralResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
