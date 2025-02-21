package com.virtual_closet_organizer.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Base64;


@Service
public class SimpleEncryptDecryptService {


    public  String base64Encription(Object response) throws Exception {
        byte[] responseBytes = response.toString().getBytes("UTF-8");

        String base64Encoded = Base64.getEncoder().encodeToString(responseBytes);
        System.out.println("Base64 Encoded: " + base64Encoded);

        String hashedValue = hashBase64String(base64Encoded);
        System.out.println("Hashed Value: " + hashedValue);
        return base64Encoded;
    }


public  String hashBase64String(String base64Encoded) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hashedBytes = digest.digest(base64Encoded.getBytes("UTF-8"));
    StringBuilder hexString = new StringBuilder();
    for (byte b : hashedBytes) {
        hexString.append(String.format("%02x", b));
    }

    return hexString.toString();
}

public String base64Decryption(String  base64Encoded){

    byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);

    String originalResponse = new String(decodedBytes);
    System.out.println("Original Response: " + originalResponse);
    return originalResponse;
}

    public  String stringHashBase64(String base64Encoded) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(base64Encoded.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }
}
