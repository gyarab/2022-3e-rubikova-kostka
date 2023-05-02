/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Projekt.MainGui;

/**
 * @author Tom
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Tom
 */
public class NapovedaController implements Initializable {

    @FXML
    private AnchorPane anchorPane;


    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @FXML
    private void zpet(ActionEvent event) {
        Parent root = ContentManager.switchContent("Lobby");
        CubeApp.mainStage.getScene().setRoot(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
