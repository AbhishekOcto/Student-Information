package com.bridgelabz.studentexceptionhandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchStudentExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ErrorResponse handleException(NoSuchStudentExistsException nsseExc){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), nsseExc.getMessage());
    }
}
