package com.shivam.restservices.firstrestservice.RestController;


import com.shivam.restservices.firstrestservice.Exceptions.EmployeeNotFound;
import com.shivam.restservices.firstrestservice.Model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public final ResponseEntity<Object> handleEmployeeNotFoundExceptions(Exception e, WebRequest request)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
