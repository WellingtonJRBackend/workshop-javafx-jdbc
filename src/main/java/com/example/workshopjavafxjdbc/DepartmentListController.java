package com.example.workshopjavafxjdbc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.example.modelEntities.Departament;
import com.example.modelService.DepartmentService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DepartmentListController implements Initializable {

    private DepartmentService service;

    @FXML
    private TableView<Departament> tableViewDepartment;
    @FXML
    private TableColumn<Departament, Integer> tableColumnId;
    @FXML
    private TableColumn<Departament, String> tableColumnName;
    @FXML
    private Button btNew;

    private ObservableList<Departament> obsList;

    @FXML
    private void onBtNewAction() {
        System.out.println("onBtNewAction");

    }

    public void setDepartmentService(DepartmentService service) {
        this.service = service;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialize();
    }

    private void initialize() {
        tableColumnId.setCellValueFactory(c -> c.getValue().idProperty().asObject());
        tableColumnName.setCellValueFactory(c -> c.getValue().nameProperty());

        Stage stage = (Stage) HelloApplication.getMainScene().getWindow();
        tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
    }

    public void updateTableView() {
        if (service == null) {
            throw new IllegalStateException("Service was null");
        }
        List<Departament> list = service.findAll();
        obsList = FXCollections.observableArrayList(list);
        tableViewDepartment.setItems(obsList);
    }
}
