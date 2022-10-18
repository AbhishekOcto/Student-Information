package com.bridgelabz.studentexceptionhandling.service;

import com.bridgelabz.studentexceptionhandling.entity.Student;

public interface IStudentService {
    public Student getStudent(Long id);

    public String addStudent(Student student);
}
