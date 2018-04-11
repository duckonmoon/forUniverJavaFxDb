package controller;

import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import service.SelectService;
import util.AlertDialog;

import java.io.Serializable;

public class DeleteController {

    public static final String SESSION = "Session";
    public static final  String LECTURER = "Lecturer";
    public static final  String STUDENT = "Student";
    public static final  String RESULT = "Result";
    public static final  String EXAM = "Exam";




    @FXML
    public ComboBox<String> choice;

    @FXML
    public ComboBox select_box;

    @FXML
    public Button delete_button;

    @FXML
    public AnchorPane anchor_pane;

    private SelectService selectService = new SelectService();

    private String aClass = null;


    public DeleteController() {
    }

    public void initialize() {
        anchor_pane.getChildren().remove(delete_button);
        delete_button.setOnAction((event -> {
            AlertDialog.createSuccessDialog("Your delete succeed");

        }));

        choice.valueProperty().addListener((ov, t, t1) -> {
            ObservableList list = FXCollections.observableArrayList();
            select_box.setVisible(true);
            if (anchor_pane.getChildren().contains(delete_button)) {
                anchor_pane.getChildren().remove(delete_button);
            }
            switch (t1) {
                case "session":
                    aClass = SESSION;
                    list.addAll(selectService.getAllSessions());
                    break;
                case "lecturer":
                    aClass = LECTURER;
                    list.addAll(selectService.getAllLecturers());
                    break;
                case "student":
                    aClass = STUDENT;
                    list.addAll(selectService.getAllStudents());
                    break;
                case "result":
                    aClass = RESULT;
                    list.addAll(selectService.getAllClearResults());
                    break;
                case "exam":
                    aClass = EXAM;
                    list.addAll(selectService.getAllClearExams());
                    break;
            }
            select_box.setItems(list);
        });

        select_box.valueProperty().addListener((ov, t, t1) -> {
            if (t1 != null && !anchor_pane.getChildren().contains(delete_button)) {
                anchor_pane.getChildren().add(delete_button);
            }
        });

        delete_button.setOnAction((event -> {
            selectService.delete(select_box.valueProperty().get(),aClass);
        }));
    }
}
