package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import service.JDBCService;
import util.AlertDialog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAllController {

    private JDBCService service = new JDBCService();

    private ObservableList<ObservableList> data;

    @FXML
    ComboBox<String> choice;

    @FXML
    TableView tableview;

    public ShowAllController() throws SQLException {
    }

    public void initialize() {
        choice.valueProperty().addListener((ov, t, t1) -> {
            ResultSet rs;
            tableview.getColumns().clear();
            data = FXCollections.observableArrayList();
            try {
                rs = service.select("Select * from " + t1);
                setColumnsNames(rs);
                getInfoFromResultSet(rs);
                tableview.setItems(data);
                closeStatementsAndResultSet(rs);
            } catch (SQLException e) {
                AlertDialog.createAlertDialog(e);
            }
        });
    }


    private void closeStatementsAndResultSet(ResultSet rs) throws SQLException {
        rs.close();
        service.closeStatement();
    }


    private void setColumnsNames(ResultSet rs) throws SQLException {
        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
            System.out.print(" ");
            final int j = i;
            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
            col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
            tableview.getColumns().addAll(col);
        }
    }

    private void getInfoFromResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.print(" ");
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));
            }
            data.add(row);
        }

    }
}
