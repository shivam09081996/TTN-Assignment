package com.shivam.restservices.firstrestservice.Exceptions;


import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ApiModel(description = "This is the Employee Not Found Exception Class")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String message) {
        super(message);
    }
}
