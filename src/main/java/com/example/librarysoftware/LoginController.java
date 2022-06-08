package com.example.librarysoftware;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    TextField userAdmin;
    @FXML
    TextField passwordAdmin;
    private String user = "Administrator";
    private String password = "2481632";

    public void loginAdmin() throws IOException {
        if(userAdmin.getText().equals(user) && passwordAdmin.getText().equals(password)){
            userAdmin.getScene().getWindow().hide();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(LibraryApplication.class.getResource("selection-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Insertion Page!");
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR IN USER OR PASSWORD");
            alert.setContentText("TRY AGAIN");
            alert.show();
            userAdmin.clear();
            passwordAdmin.clear();
        }
    }
}
