package com.example.EmployeeSpring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundEception extends RuntimeException{


    public UserNotFoundEception(String message) {
        super(message);
    }
}
