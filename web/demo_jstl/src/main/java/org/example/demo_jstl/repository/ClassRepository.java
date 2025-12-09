package org.example.demo_jstl.repository;

import org.example.demo_jstl.dto.StudentDto;
import org.example.demo_jstl.entity.ClassCG;
import org.example.demo_jstl.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository implements IClassRepository{
    @Override
    public List<ClassCG> findAll() {
        List<ClassCG> classList = new ArrayList<>();
        // Kết nối DB
        try(Connection connection = ConnectDB.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from classes");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                ClassCG classCG = new ClassCG(id,name);
                classList.add(classCG);
            }
        } catch (SQLException e) {
            System.out.println("lỗi do truỳ vấn dữ liệu");
        }
        return classList;
    }
}
