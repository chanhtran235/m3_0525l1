package org.example.demo_jstl.repository;

import org.example.demo_jstl.dto.StudentDto;
import org.example.demo_jstl.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDto> findAll();
    boolean add(Student student);
    boolean deleteById(int id);
}
