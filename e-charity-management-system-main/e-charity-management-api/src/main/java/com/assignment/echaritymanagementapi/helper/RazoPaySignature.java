package com.assignment.echaritymanagementapi.helper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.SignatureException;

public class RazoPaySignature {

    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    public static String calculateRFC2104HMAC(String data, String secret) throws java.security.SignatureException {
        String signature;
        try {
            SecretKeySpec key = new SecretKeySpec(secret.getBytes(), HMAC_SHA256_ALGORITHM);
            Mac macInstance = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            macInstance.init(key);
            byte[] rawHmac = macInstance.doFinal(data.getBytes());
            signature = DatatypeConverter.printHexBinary(rawHmac).toLowerCase();
        } catch (Exception e) {
            throw new SignatureException("failed to generate signature: " + e.getMessage());
        }
        return signature;
    }
}
