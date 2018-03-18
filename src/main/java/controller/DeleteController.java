package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteController {
    @FXML
    public TextField delete_from;
    @FXML
    public TextField where;
    @FXML
    public Button delete_button;

    public void initialize() {
        delete_button.setOnAction((event -> {

        }));
    }
}
