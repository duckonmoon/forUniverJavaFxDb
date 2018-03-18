package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;


public class Controller {

    @FXML
    private Button encode;

    @FXML
    private Button readTable;

    @FXML
    private Button readFileToDecode;

    @FXML
    private Button readKey;

    @FXML
    private Button clear;

    @FXML
    private TextArea encodedText;

    @FXML
    private TextArea decodedText;

    @FXML
    private TextArea key;

    @FXML
    private TableView<ClassInTable> table;

    private ObservableList<ClassInTable> stringList;


    public void initialize() {
        TableColumn firstNameCol = new TableColumn("char in key");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<ClassInTable, String>("symbol"));

        TableColumn lastNameCol = new TableColumn("frequency");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<ClassInTable, String>("frequency"));

        TableColumn Col = new TableColumn("char in coded");
        Col.setCellValueFactory(
                new PropertyValueFactory<ClassInTable, String>("charDecoded"));

        TableColumn Name = new TableColumn("frequency in coded");
        Name.setCellValueFactory(
                new PropertyValueFactory<ClassInTable, String>("frequencyDecoded"));
        table.getColumns().addAll(firstNameCol, lastNameCol, Col, Name);
    }

    @FXML
    private void Clear() {
        encodedText.setText("");
        decodedText.setText("");
        key.setText("");
    }

    @FXML
    private void readTable() throws Exception {
        FileChooser fc = new FileChooser();
        fc.setTitle("My File Chooser");
        File file = fc.showOpenDialog(key.getScene().getWindow());
        Scanner scanner = new Scanner(file);
        LinkedList<ClassInTable> linkedList = new LinkedList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String[] strings = string.split(" ");
            linkedList.add(new ClassInTable(Double.parseDouble(strings[1]), strings[0].charAt(0), 0, '0'));
        }
        linkedList.sort(((o1, o2) -> (int) (o2.getFrequency() * 100 - o1.getFrequency() * 100)));
        stringList = FXCollections.observableList(linkedList);
        table.setItems(stringList);
        System.out.println();
    }
}
