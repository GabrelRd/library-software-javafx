package com.example.librarysoftware;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectionController {
    @FXML
    Button btnGetScene;
    public void goToInsert() throws IOException {
        btnGetScene.getScene().getWindow().hide();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryApplication.class.getResource("insertion-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Insertion Page!");
        stage.setScene(scene);
        stage.show();
    }
    public void goToRent() throws IOException {
        btnGetScene.getScene().getWindow().hide();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryApplication.class.getResource("rent-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Rent Page!");
        stage.setScene(scene);
        stage.show();
    }
}
