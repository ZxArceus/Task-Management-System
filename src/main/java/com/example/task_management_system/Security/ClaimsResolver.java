package com.example.task_management_system.Security;

import io.jsonwebtoken.Claims;
@FunctionalInterface
public interface ClaimsResolver <T>{
    T resolve(Claims claims);
}
