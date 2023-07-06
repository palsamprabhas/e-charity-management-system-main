package com.assignment.echaritymanagementapi.helper;

import org.junit.jupiter.api.Test;

import java.security.SignatureException;

import static org.junit.jupiter.api.Assertions.*;

class RazoPaySignatureTest {

    @Test
    void calculateRFC2104HMAC() throws SignatureException {
        String signature = RazoPaySignature.calculateRFC2104HMAC("testdata", "secret");
        assertNotNull(signature);
    }
}