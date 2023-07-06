package com.assignment.echaritymanagementapi.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RazopayConfigTest {

    @Test
    public void testRazopayConfig() {
        RazopayConfig razopayConfig = new RazopayConfig();
        razopayConfig.setKey("key");
        razopayConfig.setSecret("secret");

        assertEquals(razopayConfig.getKey(), "key");
        assertEquals(razopayConfig.getSecret(), "secret");
    }

}