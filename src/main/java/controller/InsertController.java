package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.AlertDialog;

import java.sql.SQLException;

public class InsertController {
    @FXML
    public TextField insert;
    @FXML
    public TextField values;
    @FXML
    public Button insert_button;

    public InsertController() throws SQLException {
    }

    public void initialize() {
        insert_button.setOnAction((event -> {
            AlertDialog.createSuccessDialog("Your insert succeed");
            AlertDialog.createAlertDialog(new SQLException());
        }));
    }

    private String buildInsertString() {
        String sqlString = "INSERT INTO " + insert.getText() + " ";
        sqlString += "VALUES " + values.getText();
        return sqlString;
    }
}
