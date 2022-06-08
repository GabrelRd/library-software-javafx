package com.example.librarysoftware.repository;

import com.example.librarysoftware.entities.Author;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AuthorRepository {
    public Boolean save(Author author) throws SQLException{
        String name = author.getName();
        String year = author.getYearBirth();
        String desc = author.getDescription();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu"); //data conversion
        LocalDate localDate = LocalDate.parse( year , f ) ;
        String output = localDate.toString();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC",
                    "root", "841216");
            String sql = "INSERT INTO author (name, year_birth, description) " +
                    "VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,output);
            statement.setString(3,desc);
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void update(){

    }
}
