package com.example.librarysoftware.repository;

import com.example.librarysoftware.entities.BookTheme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookThemeRepository {
    public Boolean saveThemeBooks(BookTheme bookTheme) throws SQLException {
        int themeCode = bookTheme.getThemeCode();
        String bookIsbn = bookTheme.getBookIsbn();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC",
                    "root", "841216");
            String sql = "INSERT INTO theme_has_book (theme_code, book_isbn) " +
                    "VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,themeCode);
            statement.setString(2,bookIsbn);
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
