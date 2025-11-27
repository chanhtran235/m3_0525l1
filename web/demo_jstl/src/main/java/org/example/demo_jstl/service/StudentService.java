package org.example.demo_jstl.service;

import org.example.demo_jstl.entity.Student;
import org.example.demo_jstl.repository.IStudentRepository;
import org.example.demo_jstl.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
