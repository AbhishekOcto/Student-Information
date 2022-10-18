package com.bridgelabz.studentexceptionhandling.exceptions;

import org.springframework.stereotype.Component;

@Component
public class NoSuchStudentExistsException extends RuntimeException{
    private String message;

    public NoSuchStudentExistsException()  {}

    public NoSuchStudentExistsException(String message){
        super(message);
        this.message = message;
    }
}
