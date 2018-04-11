package controller;

import entity.Lecturer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.SelectService;
import util.AlertDialog;

public class InsertLecturerController {
    @FXML
    public TextField nameTextField;
    @FXML
    public Button insertButton;
    @FXML
    public TextField surnameTextField;

    private SelectService selectService = new SelectService();

    public void initialize() {
        insertButton.setOnAction(event -> {
            try{
                checkIfAllTextFieldsFilled();
                insert();
                AlertDialog.createSuccessDialog("Lecturer inserted");
            } catch (Exception e){
                AlertDialog.createAlertDialog(e);
            }
        });
    }

    private void insert() {
        Lecturer lecturer = new Lecturer();
        lecturer.setName(nameTextField.getText().trim());
        lecturer.setSurname(nameTextField.getText().trim());
        selectService.insert(lecturer);
    }

    private void checkIfAllTextFieldsFilled() throws Exception{
        if (nameTextField.getText().equals("") || surnameTextField.getText().equals("")){
            throw new Exception("Empty fields");
        }
    }
}
