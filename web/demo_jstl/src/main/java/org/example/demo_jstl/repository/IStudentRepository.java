package org.example.demo_jstl.repository;

import org.example.demo_jstl.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
