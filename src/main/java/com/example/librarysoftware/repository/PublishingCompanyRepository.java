package com.example.librarysoftware.repository;

import com.example.librarysoftware.entities.PublishingCompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PublishingCompanyRepository {
    public Boolean saveCompany(PublishingCompany publishingCompany) throws SQLException {
        String name = publishingCompany.getName();
        String initials = publishingCompany.getInitials();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC",
                    "root", "841216");
            String sql = "INSERT INTO publishing_company (name, initials) " +
                    "VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,initials);
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
