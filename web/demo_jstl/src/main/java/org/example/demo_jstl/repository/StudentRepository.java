package org.example.demo_jstl.repository;

import org.example.demo_jstl.dto.StudentDto;
import org.example.demo_jstl.entity.Student;
import org.example.demo_jstl.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final String SELECT_ALL = "select s.*, c.name as class_name from students s join classes c on s.class_id=c.id;";
    private final String SEARCH_ALL = "select s.*, c.name as class_name from students s join classes c on s.class_id=c.id where s.name like ? and c.id=?;";
    private final String SEARCH_NAME = "select s.*, c.name as class_name from students s join classes c on s.class_id=c.id where s.name like ?;";
    private final String INSERT_INTO = " insert into students(name,gender,score,class_id) values(?,?,?,?);";
    @Override
    public List<StudentDto> findAll() {
        List<StudentDto> studentList = new ArrayList<>();
        // Kết nối DB
        try(Connection connection = ConnectDB.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                String className = resultSet.getString("class_name");
                StudentDto studentDto = new StudentDto(id,name,gender,score,className);
                studentList.add(studentDto);
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
            preparedStatement.setInt(4,student.getClassId());
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

    @Override
    public List<StudentDto> search(String searchName, String classId) {
        List<StudentDto> studentList = new ArrayList<>();
        // Kết nối DB
        try(Connection connection = ConnectDB.getConnectDB()) {
            PreparedStatement preparedStatement= null;
            if (classId.equals("")){
                preparedStatement = connection.prepareStatement(SEARCH_NAME);
                preparedStatement.setString(1,"%"+searchName+"%");
            }else {
                preparedStatement = connection.prepareStatement(SEARCH_ALL);
                preparedStatement.setString(1,"%"+searchName+"%");
                preparedStatement.setString(2,classId);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float score = resultSet.getFloat("score");
                String className = resultSet.getString("class_name");
                StudentDto studentDto = new StudentDto(id,name,gender,score,className);
                studentList.add(studentDto);
            }
        } catch (SQLException e) {
            System.out.println("lỗi do truỳ vấn dữ liệu");
        }
        return studentList;
    }
}
