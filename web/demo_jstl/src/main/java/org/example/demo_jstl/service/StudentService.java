package org.example.demo_jstl.service;

import org.example.demo_jstl.dto.StudentDto;
import org.example.demo_jstl.entity.Student;
import org.example.demo_jstl.repository.IStudentRepository;
import org.example.demo_jstl.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.add(student);
    }

    @Override
    public boolean deleteById(int id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> search(String searchName, String classId) {
      return studentRepository.search(searchName,classId);
    }
}
