package com.example.librarysoftware;

import com.example.librarysoftware.entities.Rent;
import com.example.librarysoftware.repository.RentRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class RentController {
    @FXML
    TextField openRentCpfUser;
    @FXML
    TextField openRentIsbnBook;
    @FXML
    TextField openRentDate;
    @FXML
    TextField closeRentCode;
    @FXML
    TextField closeRentDate;

    public void openRent(){
        RentRepository rentRepository = new RentRepository();
        try{
            Rent rent = new Rent(openRentCpfUser.getText(),openRentIsbnBook.getText(),openRentDate.getText());
            if(rentRepository.saveRent(rent)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESSFULLY INSERTION DATA");
                alert.show();
                openRentCpfUser.clear();
                openRentIsbnBook.clear();
                openRentDate.clear();
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
    public void closeRent(){
        RentRepository rentRepository = new RentRepository();
        try{
            int price = rentRepository.endRent(Integer.parseInt(closeRentCode.getText()),closeRentDate.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("SUCCESSFULLY CLOSING RENT");
            alert.setContentText((price)+" Dollars");
            alert.show();
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR ON DATA");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
