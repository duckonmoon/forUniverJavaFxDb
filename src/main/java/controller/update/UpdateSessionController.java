package controller.update;

import entity.Session;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import service.SelectService;
import util.AlertDialog;

import java.time.ZoneId;

public class UpdateSessionController {

    @FXML
    public Button updateSessionButton;
    @FXML
    public DatePicker startDatePicker;
    @FXML
    public DatePicker endDatePicker;
    @FXML
    public ComboBox<Session> sessionPicker;

    private SelectService selectService = new SelectService();

    public void initialize() {
        updateSessionButton.setOnAction(event -> AlertDialog.createAlertDialog("Error", "Session is not modifiable", "can't modify session object"));

        sessionPicker.setItems(FXCollections.observableArrayList(selectService.getAllSessions()));

        sessionPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                startDatePicker.setValue(newValue.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                endDatePicker.setValue(newValue.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            }
        });
    }
}
