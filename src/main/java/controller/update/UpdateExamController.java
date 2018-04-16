package controller.update;

import entity.Exam;
import entity.Lecturer;
import entity.Session;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import service.SelectService;
import util.AlertDialog;

import java.time.ZoneId;
import java.util.Date;

public class UpdateExamController {
    @FXML
    public TextField subjectTextField;
    @FXML
    public DatePicker datePicker;
    @FXML
    public ComboBox<Session> sessionComboBox;
    @FXML
    public ComboBox<Lecturer> lecturerComboBox;
    @FXML
    public Button update;
    @FXML
    public ComboBox<Exam> examPicker;

    private SelectService selectService = new SelectService();

    public void initialize() {
        rerender();
        sessionComboBox.setItems(FXCollections.observableArrayList(selectService.getAllSessions()));
        lecturerComboBox.setItems(FXCollections.observableArrayList(selectService.getAllLecturers()));
        update.setOnAction(event -> {
            try {
                Exam exam = checkAllFields();
                selectService.update(exam);
                AlertDialog.createSuccessDialog("Exam updated");
            } catch (Exception e) {
                AlertDialog.createAlertDialog(e);
            }
            rerender();
        });
    }

    private void rerender() {
        examPicker.setItems(FXCollections.observableArrayList(selectService.getAllClearExams()));
        examPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                subjectTextField.setText(newValue.getSubject());
                datePicker.setValue(newValue.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                sessionComboBox.valueProperty().setValue(newValue.getSession());
                lecturerComboBox.valueProperty().setValue(newValue.getLecturer());
            }
        });
    }

    private Exam checkAllFields() throws Exception {
        Exam exam = examPicker.getValue();
        if (datePicker.getValue() != null) {
            exam.setDate(Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        } else {
            throw new Exception("empty datepicker");
        }
        if (subjectTextField.getText().equals("")) {
            throw new Exception("no subject");
        } else {
            exam.setSubject(subjectTextField.getText());
        }
        if (sessionComboBox.getValue() != null) {
            exam.setSession(sessionComboBox.getValue());
        } else {
            throw new Exception("no session");
        }
        if (lecturerComboBox.getValue() != null) {
            exam.setLecturer(lecturerComboBox.getValue());
        } else {
            throw new Exception("no lecturer");
        }
        if (exam.getDate().after(exam.getSession().getStartDate()) && exam.getDate().before(exam.getSession().getEndDate())) {
        } else {
            throw new Exception("wrong date");
        }

        return exam;
    }
}
