package controller.update;

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

public class UpdateResultController implements EventHandler<ActionEvent> {
    @FXML
    public ComboBox<Exam> examComboBox;
    @FXML
    public ComboBox<Student> studentComboBox;
    @FXML
    public ChoiceBox<String> comission1ChoiceBox;
    @FXML
    public ChoiceBox<String> comission2ChoiceBox;
    @FXML
    public TextField markTextField;
    @FXML
    public Button update;
    @FXML
    public ComboBox<Result> resultPicker;

    private SelectService selectService = new SelectService();

    public void initialize(){
        markTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                markTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        studentComboBox.setItems(FXCollections.observableArrayList(selectService.getAllStudents()));
        examComboBox.setItems(FXCollections.observableArrayList(selectService.getAllClearExams()));

        rerender();



        update.setOnAction(this);
    }

    private void rerender() {
        resultPicker.setItems(FXCollections.observableArrayList(selectService.getAllClearResults()));
        resultPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                examComboBox.valueProperty().setValue(newValue.getExam());
                studentComboBox.valueProperty().setValue(newValue.getStudent());
                comission1ChoiceBox.valueProperty().setValue(newValue.getCommision1()?"YES":"NO");
                comission2ChoiceBox.valueProperty().setValue(newValue.getCommision2()?"YES":"NO");
                markTextField.setText("" + newValue.getMark());
            }
        });
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            Result result = checkAllFields();
            updateResult(result);
            AlertDialog.createSuccessDialog("Result updated");
        } catch (Exception e){
            AlertDialog.createAlertDialog(e);
        }
        rerender();
    }

    private void updateResult(Result result) {
        selectService.update(result);
    }

    private Result checkAllFields() throws Exception {
        Result result = resultPicker.getValue();
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
}
