package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.JDBCService;
import util.AlertDialog;

import java.sql.SQLException;

public class InsertController {
    @FXML
    public TextField insert;
    @FXML
    public TextField values;
    @FXML
    public Button insert_button;

    private JDBCService jdbcService = new JDBCService();

    public void initialize() {
        insert_button.setOnAction((event -> {
            try {
                jdbcService.execSQL(buildInsertString());
                AlertDialog.createSuccessDialog("Your insert succeed");
            } catch (SQLException e) {
                AlertDialog.createAlertDialog(e);
            }
        }));
    }

    private String buildInsertString() {
        String sqlString = "INSERT INTO " + insert.getText() + " ";
        sqlString += "VALUES " + values.getText();
        return sqlString;
    }
}
