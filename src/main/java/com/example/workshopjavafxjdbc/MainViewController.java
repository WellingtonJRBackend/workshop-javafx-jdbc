package com.example.workshopjavafxjdbc;

import com.example.gui.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import com.example.modelService.DepartmentService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemAbout;

    public void onMenuItemSellerAction() {
        System.out.println("onMenuItemSellerAction");

    }

    public void onMenuItemDepartmentAction() {

        loadView2("/DepartmentList.fxml");
    }

    public void onMenuItemAboutAction() {
        loadView("/About.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private synchronized void loadView(String absolutenName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutenName));
            VBox newVbox = loader.load();

            Scene mainScene = HelloApplication.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVbox.getChildren());
        } catch (IOException e) {
            Alerts.showAlert("IO Exception ", "Error loading view ", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private synchronized void loadView2(String absolutenName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutenName));
            VBox newVbox = loader.load();

            Scene mainScene = HelloApplication.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu  = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVbox.getChildren());

            DepartmentListController controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();

        } catch (IOException e) {
            Alerts.showAlert("IO Exception ", "Error loading view ", e.getMessage(), Alert.AlertType.ERROR);
        }

    }
}


