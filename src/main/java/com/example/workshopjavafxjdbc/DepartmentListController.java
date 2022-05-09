package com.example.workshopjavafxjdbc;

import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelEntities.Departmet;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartmentListController implements Initializable {
    @FXML
    private TableView<Departmet>  tableViewDepartment;
    @FXML
    private TableColumn<Departmet,Integer> tableColumnId;
    @FXML
    private TableColumn<Departmet,String> tableColumnName;
    @FXML
    private Button btNew;
    @FXML
    private void onBtNewAction(){
        System.out.println("onBtNewAction");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    initialize();
    }

    private void initialize() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        Stage stage = (Stage) HelloApplication.getMainScene().getWindow();
        tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
    }
}
