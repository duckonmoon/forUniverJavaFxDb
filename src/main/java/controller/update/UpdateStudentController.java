package controller.update;

import entity.Student;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import service.SelectService;
import util.AlertDialog;

public class UpdateStudentController {
    @FXML
    public TextField nameTextField;
    @FXML
    public TextField identicalNumberTextField;
    @FXML
    public TextField surnameTextField;
    @FXML
    public Button update;
    @FXML
    public ComboBox<Student> studentPicker;
    @FXML
    public ComboBox<String> expelledPicker;

    private SelectService selectService = new SelectService();

    public void initialize(){
        identicalNumberTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                identicalNumberTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        rerender();
        update.setOnAction(event -> {
            try {
                Student student = checkAllFields();
                selectService.update(student);
                AlertDialog.createSuccessDialog("Student updated");
            } catch (Exception e){
                AlertDialog.createAlertDialog(e);
            }
            rerender();
        });
    }

    private void rerender() {
        studentPicker.setItems(FXCollections.observableArrayList(selectService.getAllStudents()));
        studentPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                nameTextField.setText(newValue.getName());
                surnameTextField.setText(newValue.getSurname());
                identicalNumberTextField.setText("" + newValue.getIdentical_number());
                expelledPicker.valueProperty().setValue(newValue.getExpelled()?"YES":"NO");
            }
        });
    }

    private Student checkAllFields() throws Exception {
        Student student = studentPicker.getValue();
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
        student.setExpelled(expelledPicker.valueProperty().get().toLowerCase().equals("yes"));
        return student;
    }
}
