package org.example.demo_jstl.repository;

import org.example.demo_jstl.entity.Student;
import org.example.demo_jstl.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final String SELECT_ALL = "select * from students;";
    private final String INSERT_INTO = " insert into students(name,gender,score) values(?,?,?);";
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        // Kết nối DB
        try(Connection connection = ConnectDB.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                Student student = new Student(id,name,gender,score);
                studentList.add(student);
            }
        } catch (SQLException e) {
            System.out.println("lỗi do truỳ vấn dữ liệu");
        }
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        // kết nói DB
        try(Connection connection = ConnectDB.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setFloat(3,student.getScore());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            System.out.println("lỗi do truỳ vấn dữ liệu");
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        // kết nối DB
        return false;
    }
}
