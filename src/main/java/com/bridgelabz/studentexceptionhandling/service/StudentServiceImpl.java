package com.bridgelabz.studentexceptionhandling.service;

import com.bridgelabz.studentexceptionhandling.entity.Student;
import com.bridgelabz.studentexceptionhandling.exceptions.NoSuchStudentExistsException;
import com.bridgelabz.studentexceptionhandling.exceptions.StudentAlreadyExistsException;
import com.bridgelabz.studentexceptionhandling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentRepository studentRepo;

    @Override
    public Student getStudent(Long id) {
        Student studentdata = studentRepo.findById(id)
                .orElseThrow(() ->
                        new NoSuchStudentExistsException("There is no such student with id: "+ id));
        return studentdata;
    }

    @Override
    public String addStudent(Student student) {
        Student studentExists = studentRepo.findById(student.getId()).orElse(null);
        if(studentExists == null){
            studentRepo.save(student);
            return "Student successfully added";
        }
        else{
            throw new StudentAlreadyExistsException("Student already exists.");
        }

    }
}
