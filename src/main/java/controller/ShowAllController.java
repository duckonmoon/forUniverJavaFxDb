package controller;

import dto.*;
import entity.Lecturer;
import entity.Session;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.SelectService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowAllController {

    @FXML
    ComboBox<String> choice;
    @FXML
    TableView tableview;
    private SelectService selectService = new SelectService();

    public ShowAllController() {
    }

    public void initialize() {
        choice.valueProperty().addListener((ov, t, t1) -> {
            ObservableList data = FXCollections.observableArrayList();
            tableview.getColumns().clear();
            switch (t1) {
                case "session":
                    addColumnsToTableView(SessionDTO.class, tableview);
                    data.addAll(selectService.getAllSessions());
                    break;
                case "lecturer":
                    addColumnsToTableView(LecturerDTO.class, tableview);
                    data.addAll(selectService.getAllLecturers());
                    break;
                case "student":
                    addColumnsToTableView(StudentDTO.class, tableview);
                    data.addAll(selectService.getAllStudents());
                    break;
                case "result":
                    addColumnsToTableView(ResultDTO.class, tableview);
                    data.addAll(selectService.getAllResults());
                    break;
                case "exam":
                    addColumnsToTableView(ExamDTO.class, tableview);
                    data.addAll(selectService.getAllExams());
                    break;
            }
            tableview.setItems(data);
        });
    }

    private void addColumnsToTableView(Class<?> classs, TableView tableView) {
        List<TableColumn> tableColumns = new ArrayList<>();
        do {
            Field[] fields = classs.getDeclaredFields();
            for (Field field : fields) {
                TableColumn column = new TableColumn(field.getName());
                column.setCellValueFactory(
                        new PropertyValueFactory<Session, String>(field.getName()));
                tableColumns.add(column);
            }
            classs = classs.getSuperclass();
        } while (classs != null);

        Collections.reverse(tableColumns);
        for (TableColumn column : tableColumns) {
            tableView.getColumns().add(column);
        }
    }
}
