package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.AlertDialog;

import java.sql.SQLException;

public class UpdateController {
    @FXML
    public TextField update;

    @FXML
    public TextField where;

    @FXML
    public TextField set;

    @FXML
    public Button update_button;

    @FXML
    AnchorPane container;

    public UpdateController() throws SQLException {
    }

    public void initialize() {
        update_button.setOnAction((event -> {

            AlertDialog.createSuccessDialog("Your update succeed");


        }));
    }

    private String buildUpdateString() {
        String sqlString = "UPDATE " + update.getText() + " ";
        sqlString += "SET " + set.getText();
        sqlString += "WHERE " + where.getText();
        return sqlString;
    }
}
