package com.example.task_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AuthorizationException extends  RuntimeException{
    public AuthorizationException(){
        super("Not Authorized");
    }
}
