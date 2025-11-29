package org.example.demo_jstl.repository;

import org.example.demo_jstl.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh",true,3.0f));
        studentList.add(new Student(2,"Hương",false,8.0f));
        studentList.add(new Student(3,"Tiến",true,6.0f));
    }
    @Override
    public List<Student> findAll() {
        // Kết nối DB
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        // kết nói DB
        return studentList.add(student);
    }

    @Override
    public boolean deleteById(int id) {
        // kết nối DB
        for (int i = 0; i <studentList.size() ; i++) {
            if (studentList.get(i).getId()==id){
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }
}
