package controller.insert;

import entity.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import service.SelectService;
import util.AlertDialog;

import java.time.ZoneId;
import java.util.Date;

public class InsertSessionController {
    @FXML
    public DatePicker startDatePicker;
    @FXML
    public DatePicker endDatePicker;
    @FXML
    public Button insertSessionButton;

    private SelectService selectService = new SelectService();

    public void initialize() {
        insertSessionButton.setOnAction((event -> {
            if (startDatePicker.getValue() != null && endDatePicker.getValue() != null) {
                Date startDate = Date.from(startDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date endDate = Date.from(endDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                if(endDate.compareTo(startDate) <= 0){
                    AlertDialog.createAlertDialog("Error","Incorrect Input","end date cant be before start date");
                } else{
                    try {
                        Session session = new Session();
                        session.setStartDate(startDate);
                        session.setEndDate(endDate);
                        selectService.insert(session);
                        AlertDialog.createSuccessDialog("Session inserted");
                    } catch (Exception e){
                        AlertDialog.createAlertDialog(e);
                    }

                }
            } else {
                AlertDialog.createAlertDialog("Error","Fill all fields","Some fields are empty!");
            }
        }));
    }

}
