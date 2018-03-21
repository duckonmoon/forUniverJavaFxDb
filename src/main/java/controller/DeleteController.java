package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.JDBCService;
import util.AlertDialog;

import java.sql.SQLException;

public class DeleteController {
    @FXML
    public TextField delete_from;
    @FXML
    public TextField where;
    @FXML
    public Button delete_button;

    private JDBCService jdbcService = new JDBCService();

    public void initialize() {
        delete_button.setOnAction((event -> {
            try {
                jdbcService.execSQL(buildDeleteString());
                AlertDialog.createSuccessDialog("Your delete succeed");
            } catch (SQLException e) {
                AlertDialog.createAlertDialog(e);
            }
        }));
    }

    private String buildDeleteString() {
        String sqlString = "DELETE FROM " + delete_from.getText() + " ";
        sqlString += "WHERE " + where.getText();
        return sqlString;
    }
}
