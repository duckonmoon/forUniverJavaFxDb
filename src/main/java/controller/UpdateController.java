package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    public void initialize() {
        update_button.setOnAction((event -> {

        }));
    }
}
