package com.example.librarysoftware;

import com.example.librarysoftware.entities.*;
import com.example.librarysoftware.repository.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class InsertionController {
    @FXML
    TextField authorName;
    @FXML
    TextField authorYearBirth;
    @FXML
    TextField authorDescription;
    @FXML
    TextField bookISBN;
    @FXML
    TextField bookName;
    @FXML
    TextField bookQuantity;
    @FXML
    TextField bookReleaseYear;
    @FXML
    TextField bookEdition;
    @FXML
    TextField bookPublishingCode;
    @FXML
    TextField bookAuthorCode;
    @FXML
    TextField publishingName;
    @FXML
    TextField publishingInitials;
    @FXML
    TextField themeName;
    @FXML
    TextField themeDescription;
    @FXML
    TextField themeBooksID;
    @FXML
    TextField themeBooksISBN;
    @FXML
    TextField userCPF;
    @FXML
    TextField userName;
    @FXML
    TextField userEmail;
    @FXML
    TextField userAddress;

    public void buttonSaveAuthor() throws SQLException {
        AuthorRepository authorRepository = new AuthorRepository();
        try {
            Author author = new Author(authorName.getText(), authorYearBirth.getText(), authorDescription.getText());
            if(authorRepository.save(author)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESSFULLY INSERTION DATA");
                alert.show();
                authorName.clear();
                authorYearBirth.clear();
                authorDescription.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR INSERTING DATA");
                alert.setContentText("ERROR ON DATA TYPE");
                alert.show();
            }
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR INSERTING FIELDS");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    public void buttonSaveBook() throws SQLException{
        BookRepository bookRepository = new BookRepository();
        try {
            Book book = new Book(bookISBN.getText(),bookName.getText(),Integer.parseInt(bookQuantity.getText()),
                    bookReleaseYear.getText(),bookEdition.getText(),Integer.parseInt(bookPublishingCode.getText()),
                    Integer.parseInt(bookAuthorCode.getText()));
            if (bookRepository.saveBook(book)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESSFULLY INSERTION DATA");
                alert.show();
                bookISBN.clear();
                bookName.clear();
                bookQuantity.clear();
                bookReleaseYear.clear();
                bookEdition.clear();
                bookPublishingCode.clear();
                bookAuthorCode.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR INSERTING DATA");
                alert.setContentText("ERROR ON DATA TYPE");
                alert.show();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR INSERTING FIELDS");
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }
    public void buttonSavePubCompany(){
        PublishingCompanyRepository publishingCompanyRepository = new PublishingCompanyRepository();
        try{
            PublishingCompany publishingCompany = new PublishingCompany(publishingName.getText(),publishingInitials.getText());
            if(publishingCompanyRepository.saveCompany(publishingCompany)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESSFULLY INSERTION DATA");
                alert.show();
                publishingName.clear();
                publishingInitials.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR INSERTING DATA");
                alert.setContentText("ERROR ON DATA TYPE");
                alert.show();
            }
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR INSERTING FIELDS");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    public void buttonSaveTheme(){
        ThemeRepository themeRepository = new ThemeRepository();
        try{
            Theme theme = new Theme(themeName.getText(),themeDescription.getText());
            if(themeRepository.saveTheme(theme)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESSFULLY INSERTION DATA");
                alert.show();
                themeName.clear();
                themeDescription.clear();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR INSERTING DATA");
                alert.setContentText("ERROR ON DATA TYPE");
                alert.show();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR INSERTING FIELDS");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    public void buttonSaveThemeBooks(){
        BookThemeRepository bookThemeRepository = new BookThemeRepository();
        try{
            BookTheme bookTheme = new BookTheme(Integer.parseInt(themeBooksID.getText()),themeBooksISBN.getText());
            if(bookThemeRepository.saveThemeBooks(bookTheme)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESSFULLY INSERTION DATA");
                alert.show();
                themeBooksID.clear();
                themeBooksID.clear();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR INSERTING DATA");
                alert.setContentText("ERROR ON DATA TYPE");
                alert.show();
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR INSERTING FIELDS");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    public void buttonSaveUser(){
        UserRepository userRepository = new UserRepository();
        try{
            User user = new User(userCPF.getText(),userEmail.getText(),userAddress.getText(),userName.getText());
            if(userRepository.saveUser(user)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESSFULLY INSERTION DATA");
                alert.show();
                userCPF.clear();
                userEmail.clear();
                userAddress.clear();
                userName.clear();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR INSERTING DATA");
                alert.setContentText("ERROR ON DATA TYPE");
                alert.show();
            }
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR INSERTING FIELDS");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
