package org.example.demo_jstl.service;

import org.example.demo_jstl.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

}
