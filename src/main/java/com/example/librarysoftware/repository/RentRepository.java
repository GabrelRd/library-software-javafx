package com.example.librarysoftware.repository;

import com.example.librarysoftware.entities.Rent;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class RentRepository {
    public Boolean saveRent(Rent rent) throws SQLException {
        String cpfUser = rent.getUserCpf();
        String bookIsbn = rent.getBookIsbn();
        String date = rent.getRentInitDate();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu"); //data conversion
        LocalDate localDate = LocalDate.parse( date , f ) ;
        String initDate = localDate.toString();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC",
                    "root", "841216");
            String sqlAuthor = "INSERT INTO rent (user_cpf, book_isbn, rent_date) " +
                    "VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlAuthor);
            statement.setString(1,cpfUser);
            statement.setString(2,bookIsbn);
            statement.setString(3,initDate);
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public int endRent(int rentCode, String dateClose){
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu"); //data conversion
            LocalDate finalDate = LocalDate.parse( dateClose , f ) ;
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC",
                    "root", "841216");
            String sql = "SELECT rent_date FROM rent WHERE code="+rentCode;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Date rent = resultSet.getDate("rent_date");
                Date date = Date.valueOf(finalDate);
                LocalDate rentDateBegin = rent.toLocalDate();
                LocalDate dateFinalRent = date.toLocalDate();
                Period age = Period.between(rentDateBegin,dateFinalRent);
                int price = age.getMonths() + (age.getYears()*12);
                return price;
            }
            connection.close();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
