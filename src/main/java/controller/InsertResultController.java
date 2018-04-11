package controller;

import entity.Exam;
import entity.Result;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import service.SelectService;
import util.AlertDialog;

public class InsertResultController implements EventHandler<ActionEvent> {

    @FXML
    public Button insert;
    @FXML
    public TextField markTextField;
    @FXML
    public ChoiceBox<String> comission1ChoiceBox;
    @FXML
    public ChoiceBox<String> comission2ChoiceBox;
    @FXML
    public ComboBox<Student> studentComboBox;
    @FXML
    public ComboBox<Exam> examComboBox;

    private SelectService selectService = new SelectService();

    public void initialize() {
        markTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                markTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        ObservableList<Student> students = FXCollections.observableArrayList();
        ObservableList<Exam> exams = FXCollections.observableArrayList();
        students.addAll(selectService.getAllStudents());
        exams.addAll(selectService.getAllClearExams());
        studentComboBox.setItems(students);
        examComboBox.setItems(exams);

        insert.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            Result result = checkAllFields();
            insertExam(result);
            AlertDialog.createSuccessDialog("Result inserted");
        } catch (Exception e){
            AlertDialog.createAlertDialog(e);
        }
    }

    private Result checkAllFields() throws Exception {
        Result result = new Result();
        if (examComboBox.getValue()==null){
            throw new Exception("pls select exam");
        }
        result.setExam(examComboBox.getValue());
        if (studentComboBox.getValue()==null){
            throw new Exception("pls select student");
        }
        result.setStudent(studentComboBox.getValue());
        if (comission1ChoiceBox.getValue() == null || comission2ChoiceBox.getValue()==null){
            throw new Exception("pls provide correct info about comissions");
        }
        result.setCommision1(comission1ChoiceBox.getValue().toLowerCase().equals("yes"));
        result.setCommision2(comission2ChoiceBox.getValue().toLowerCase().equals("yes"));
        if (!result.getCommision1() && result.getCommision2()){
            throw new Exception("pls provide correct info about comissions");
        }
        if (markTextField.getText().equals("")){
            throw new Exception("mark not found");
        }
        result.setMark(Integer.parseInt(markTextField.getText()));
        if(result.getMark()< 0 || result.getMark()>5){
            throw new Exception("wrong mark");
        }
        return result;
    }

    private void insertExam(Result result) {
        selectService.insert(result);
    }
}
