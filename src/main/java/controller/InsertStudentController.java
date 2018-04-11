package controller;

import entity.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.SelectService;
import util.AlertDialog;

public class InsertStudentController implements EventHandler<ActionEvent> {
    @FXML
    public TextField nameTextField;
    @FXML
    public TextField surnameTextField;
    @FXML
    public TextField identicalNumberTextField;
    @FXML
    public Button insert;

    private SelectService selectService = new SelectService();

    public void initialize() {
        identicalNumberTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                identicalNumberTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        insert.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            Student student = checkAllFields();
            insertExam(student);
            AlertDialog.createSuccessDialog("Student inserted");
        } catch (Exception e) {
            AlertDialog.createAlertDialog(e);
        }
    }

    private void insertExam(Student student) {
        selectService.insert(student);
    }

    private Student checkAllFields() throws Exception {
        Student student = new Student();
        if (nameTextField.getText().equals("")) {
            throw new Exception("empty name field");
        }
        student.setName(nameTextField.getText());
        if (surnameTextField.getText().equals("")) {
            throw new Exception("empty surname field");
        }
        student.setSurname(surnameTextField.getText());
        if (identicalNumberTextField.getText().equals("")) {
            throw new Exception("empty identical number field");
        }
        student.setIdentical_number(Long.parseLong(identicalNumberTextField.getText()));
        student.setExpelled(false);
        return student;
    }
}
