package com.example.corebase.infrastructure.tokenCustom;

import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenUtils {

    @Value("${token.decode.secret}")
    private String decodeSecret;

    @Value("${token.secret}")
    private String clientSecret;

    @Value("${token.time_expires}")
    private String timeExpires;

    public String generateToken(TokenDto payload) {
        try {
            long nowMillis = System.currentTimeMillis();
            long expirationMillis = nowMillis + (Integer.parseInt(timeExpires) * 60 * 60 * 1000);

            Gson gson = new Gson();
            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            header.put("typ", "JWT");
            header.put("exp", expirationMillis);

            // Tạo phần header của token (base64 encoded)
            String headerJson = gson.toJson(header);
            String encodedHeader = Base64.getEncoder().encodeToString(headerJson.getBytes());

            // Tạo phần payload của token (base64 encoded)
            String payloadJson = gson.toJson(payload);
            String encodedPayload = Base64.getEncoder().encodeToString(payloadJson.getBytes());

            // Tạo chuỗi unsigned token
            String unsignedToken = encodedHeader + decodeSecret + encodedPayload;

            // Tạo chữ ký cho token
            String signature = generateHmacSHA256Signature(unsignedToken, clientSecret);

            // Tạo token hoàn chỉnh
            String token = unsignedToken + decodeSecret + signature;

            return Base64.getEncoder().encodeToString(token.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generateHmacSHA256Signature(String data, String key) throws Exception {
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        sha256Hmac.init(secretKey);
        byte[] signatureBytes = sha256Hmac.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    public Map<String, Object> decodeToken(String token) {
        try {
            Gson gson = new Gson();
            // Tách token thành các phần header, payload và chữ ký
            String[] parts = new String(Base64.getDecoder().decode(token)).split(decodeSecret);
            String encodedHeader = parts[0];
            String encodedPayload = parts[1];
            String signature = parts[2];

            // Decode header và payload từ Base64
            String decodedPayload = new String(Base64.getDecoder().decode(encodedPayload));

            // Kiểm tra chữ ký của token
            String unsignedToken = encodedHeader + decodeSecret + encodedPayload;
            String expectedSignature = generateHmacSHA256Signature(unsignedToken, clientSecret);
            if (!signature.equals(expectedSignature)) {
                throw new RuntimeException("Invalid signature");
            }

            // Chuyển đổi payload thành Map
            Map<String, Object> payload = gson.fromJson(decodedPayload, Map.class);
            return payload;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean validateToken(String token) {
        try {
            String[] parts = new String(Base64.getDecoder().decode(token)).split(decodeSecret);
            String encodedHeader = parts[0];
            String encodedPayload = parts[1];
            String signature = parts[2];

            // Kiểm tra chữ ký của token
            String unsignedToken = encodedHeader + decodeSecret + encodedPayload;
            String expectedSignature = generateHmacSHA256Signature(unsignedToken, clientSecret);
            if (!signature.equals(expectedSignature)) {
                System.err.println("Token validate error: " + "Secret is not in the correct format");
                return false;
            }

            return true;
        } catch (Exception e) {
            System.err.println("Token validate error: " + e.getMessage());
            return false;
        }
    }

    public Boolean checkExpirationToken(String token) {
        try {
            Gson gson = new Gson();

            // Tách token thành các phần header, payload và chữ ký
            String[] parts = new String(Base64.getDecoder().decode(token)).split(decodeSecret);
            String encodedHeader = parts[0];

            // Decode header và payload từ Base64
            String decodedHeader = new String(Base64.getDecoder().decode(encodedHeader));
            Map<String, Object> header = gson.fromJson(decodedHeader, Map.class);

            long nowMillis = System.currentTimeMillis();
            long expirationMillis = (Long) header.get("exp");

            if (expirationMillis < nowMillis) {
                System.err.println("Token validate error: " + "Token expired.");
                return false;
            }

            return true;
        } catch (Exception e) {
            System.err.println("Token validate error: " + e.getMessage());
            return false;
        }
    }

}
