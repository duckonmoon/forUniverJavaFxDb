package controller.update;

import entity.Lecturer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import service.SelectService;
import util.AlertDialog;

import java.util.List;

public class UpdateLecturerController {
    @FXML
    public Button updateButton;
    @FXML
    public TextField nameTextField;
    @FXML
    public TextField surnameTextField;
    @FXML
    public ComboBox<Lecturer> lecturerPicker;

    private SelectService selectService = new SelectService();

    public void initialize() {
        lecturerPicker.setItems(FXCollections.observableArrayList(selectService.getAllLecturers()));
        lecturerPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nameTextField.setText(newValue.getName());
                surnameTextField.setText(newValue.getSurname());
            }
        });

        updateButton.setOnAction(event -> {
            try {
                checkIfAllTextFieldsFilled();
                update();
                AlertDialog.createSuccessDialog("Lecturer updated");
                rerender();
            } catch (Exception e) {
                AlertDialog.createAlertDialog(e);
            }
        });
    }

    private void rerender() {
        List<Lecturer> lecturers = selectService.getAllLecturers();
        lecturerPicker.setItems(FXCollections.observableArrayList(lecturers));
        lecturerPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            nameTextField.setText(newValue.getName());
            surnameTextField.setText(newValue.getSurname());
        });
    }

    private void update() {
        Lecturer lecturer = lecturerPicker.valueProperty().get();
        lecturer.setName(nameTextField.getText());
        lecturer.setSurname(surnameTextField.getText());
        selectService.update(lecturer);
    }


    private void checkIfAllTextFieldsFilled() throws Exception {
        if (lecturerPicker.valueProperty().get() == null && nameTextField.getText().equals("") || surnameTextField.getText().equals("")) {
            throw new Exception("Empty fields");
        }
    }
}
