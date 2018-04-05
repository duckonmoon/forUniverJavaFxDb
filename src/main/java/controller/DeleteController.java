package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.AlertDialog;

import java.sql.SQLException;

public class DeleteController {
    @FXML
    public TextField delete_from;
    @FXML
    public TextField where;
    @FXML
    public Button delete_button;

    public DeleteController() throws SQLException {
    }

    public void initialize() {
        delete_button.setOnAction((event -> {
            AlertDialog.createSuccessDialog("Your delete succeed");

        }));
    }

    private String buildDeleteString() {
        String sqlString = "DELETE FROM " + delete_from.getText() + " ";
        sqlString += "WHERE " + where.getText();
        return sqlString;
    }
}
