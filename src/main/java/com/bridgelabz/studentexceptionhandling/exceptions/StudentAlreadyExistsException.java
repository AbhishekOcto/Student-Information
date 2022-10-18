package com.bridgelabz.studentexceptionhandling.exceptions;

import org.springframework.stereotype.Component;

@Component
public class StudentAlreadyExistsException extends RuntimeException{
    private String message;

    public StudentAlreadyExistsException()  {}
    public StudentAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
