package com.shivam.restservices.firstrestservice.Model;

import io.swagger.annotations.ApiModel;

import java.util.Date;
@ApiModel(description = "This is the Model for Exception Class Controller")
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}