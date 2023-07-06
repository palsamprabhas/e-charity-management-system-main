package com.assignment.echaritymanagementapi.model;

import com.assignment.echaritymanagementapi.services.model.GeneralResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralResponseTest {

    @Test
    public void testGeneralResponse() {
        GeneralResponse generalResponse = new GeneralResponse("test-message");
        assertEquals("test-message", generalResponse.getMessage());
        generalResponse.setMessage("test-message-updated");
        assertEquals("test-message-updated", generalResponse.getMessage());
    }

}