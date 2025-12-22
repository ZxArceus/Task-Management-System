package com.example.task_management_system.Security;

import io.jsonwebtoken.Jwts;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Set;

public class JwtTokenProvider {
    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.access-token-expiry}")
    private Long jwtExpirationMs;
    @Value("${security.jwt.refresh-token-expiry}")
    private Long jwtRefreshExpirationMs;

//    public   String generateAccessToken(ObjectId userId, String userName) {
//
//    }
//    public   String generateRefreshToken(ObjectId userId) {
//
//    }
//
//    public   ObjectId getUserIdFromToken(String token) {
//
//    }
//    public   String getUserNameFromToken(String token) {
//
//    }
//    public   boolean validateToken(String token) {
//
//    }
//    public   Set<String> getRolesFromToken(String token) {
//
//    }



}
