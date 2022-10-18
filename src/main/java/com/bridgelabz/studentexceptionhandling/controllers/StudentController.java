package com.bridgelabz.studentexceptionhandling.controllers;

import com.bridgelabz.studentexceptionhandling.entity.Student;
import com.bridgelabz.studentexceptionhandling.exceptions.ErrorResponse;
import com.bridgelabz.studentexceptionhandling.exceptions.StudentAlreadyExistsException;
import com.bridgelabz.studentexceptionhandling.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @ExceptionHandler(value = StudentAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleStudentAlreadyPresent(StudentAlreadyExistsException saeeExc){
        return new ErrorResponse(HttpStatus.CONFLICT.value(), saeeExc.getMessage());
    }
}
