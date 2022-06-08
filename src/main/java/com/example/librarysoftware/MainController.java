package com.example.librarysoftware;

import com.example.librarysoftware.entities.Book;
import com.example.librarysoftware.repository.BookRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    @FXML
    private TextField txtGetSearch;
    @FXML
    private ListView<String> listBook;
    @FXML
    private Button btnGetScene;

    @FXML
    protected void onBtnLogin() throws IOException {
        btnGetScene.getScene().getWindow().hide();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login Page!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onBtnSearch(){
        BookRepository bookRepository = new BookRepository();
        ArrayList<String> list = bookRepository.listAllBooks();
        for (int i=0; i>list.size() ;i++) {
            listBook.getItems().clear();
            listBook.getItems().add(list.get(i));
        }
    }
}