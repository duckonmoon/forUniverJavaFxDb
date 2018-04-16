package controller.insert;

import entity.Exam;
import entity.Lecturer;
import entity.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import service.SelectService;
import util.AlertDialog;

import java.time.ZoneId;
import java.util.Date;

public class InsertExamController implements EventHandler<ActionEvent>{
    @FXML
    public TextField subjectTextField;
    @FXML
    public DatePicker datePicker;
    @FXML
    public ComboBox<Session> sessionComboBox;
    @FXML
    public ComboBox<Lecturer> lecturerComboBox;
    @FXML
    public Button insert;

    private SelectService selectService = new SelectService();

    public void initialize() {
        ObservableList<Session> sessions = FXCollections.observableArrayList();
        ObservableList<Lecturer> lecturers = FXCollections.observableArrayList();
        sessions.addAll(selectService.getAllSessions());
        lecturers.addAll(selectService.getAllLecturers());
        sessionComboBox.setItems(sessions);
        lecturerComboBox.setItems(lecturers);

        insert.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            Exam exam = checkAllFields();
            insertExam(exam);
            AlertDialog.createSuccessDialog("Exam inserted");
        } catch (Exception e){
            AlertDialog.createAlertDialog(e);
        }
    }

    private void insertExam(Exam exam) {
        selectService.insert(exam);
    }

    private Exam checkAllFields() throws Exception{
        Exam exam = new Exam();
        if (datePicker.getValue()!=null)
        {
            exam.setDate(Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        } else{
            throw new Exception("empty datepicker");
        }
        if (subjectTextField.getText().equals("")){
            throw new Exception("no subject");
        } else {
            exam.setSubject(subjectTextField.getText());
        }
        if (sessionComboBox.getValue()!=null){
            exam.setSession(sessionComboBox.getValue());
        } else {
            throw new Exception("no session");
        }
        if (lecturerComboBox.getValue()!=null){
            exam.setLecturer(lecturerComboBox.getValue());
        } else {
            throw new Exception("no lecturer");
        }
        if (exam.getDate().after(exam.getSession().getStartDate()) && exam.getDate().before(exam.getSession().getEndDate())){
        } else {
            throw new Exception("wrong date");
        }

        return exam;
    }
}
