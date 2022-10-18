package com.bridgelabz.studentexceptionhandling.repository;

import com.bridgelabz.studentexceptionhandling.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
