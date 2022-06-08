package com.example.librarysoftware.repository;

import com.example.librarysoftware.entities.Book;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BookRepository {
    public Boolean saveBook(Book book) throws SQLException{
        String isbn = book.getIsbn();
        String name = book.getName();
        int quantity = book.getQuantity();
        String year = book.getReleaseYear();
        String edition = book.getEdition();
        int pubId = book.getPublishingID();
        int authorId = book.getAuthorID();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu"); //data conversion
        LocalDate localDate = LocalDate.parse( year , f ) ;
        String outputYear = localDate.toString();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC",
                    "root", "841216");
            String sqlAuthor = "INSERT INTO book (isbn, name, quantity, release_year, edition, publishing_company_code, author_author_id) " +
                    "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlAuthor);
            statement.setString(1,isbn);
            statement.setString(2,name);
            statement.setInt(3,quantity);
            statement.setString(4,outputYear);
            statement.setString(5,edition);
            statement.setInt(6,pubId);
            statement.setInt(7,authorId);
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<String> listAllBooks(){
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC",
                    "root", "841216");
            String sql = "SELECT isbn, name, release_year, edition FROM book";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                list.add(resultSet.getString("isbn")+resultSet.getString("name")+resultSet.getString("release_year")+
                        resultSet.getString("edition"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
