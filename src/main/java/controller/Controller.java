package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import service.JDBCService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {


    JDBCService service = new JDBCService();

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
            try {
                rs = service.getAllEntities();
                setColumnsNames(rs);
                getInfoFromResultSet(rs);
                tableview.setItems(data);
                closeStatementsAndResultSet(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void closeStatementsAndResultSet(ResultSet rs) throws SQLException {
        rs.close();
        service.closeStatement();
    }


    private void setColumnsNames(ResultSet rs) throws SQLException {
        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
            final int j = i;
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
            col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
            tableview.getColumns().addAll(col);
        }
    }

    private void getInfoFromResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));
            }
            data.add(row);
        }
    }
}
