package com.example.librarysoftware.repository;


import com.example.librarysoftware.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserRepository {
    public Boolean saveUser(User user) throws SQLException {
        String name = user.getName();
        String email = user.getEmail();
        String address = user.getAddress();
        String cpf = user.getCpf();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC",
                    "root", "841216");
            String sql = "INSERT INTO user (name, email, adress, cpf) " +
                    "VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,address);
            statement.setString(4,cpf);
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
