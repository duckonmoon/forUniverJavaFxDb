package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.AlertDialog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {


    @FXML
    AnchorPane container;

    @FXML
    Button click;

    @FXML
    TextField textarea;

    @FXML
    TableView tableview;

    private ObservableList<ObservableList> data;

    public Controller() throws SQLException {
    }

    public void initialize() {


        click.setOnAction(event -> {
            ResultSet rs;
            tableview.getColumns().clear();
            data = FXCollections.observableArrayList();
            tableview.setItems(data);

            AlertDialog.createAlertDialog(new SQLException());
        });
    }

    private String buildSelectString() {
        String sqlString = "SELECT " + textarea.getText();
        return sqlString;
    }
}
