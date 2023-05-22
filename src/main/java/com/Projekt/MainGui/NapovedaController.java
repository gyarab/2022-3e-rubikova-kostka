/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Projekt.MainGui;

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

public class NapovedaController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    void zpet(ActionEvent event) {
        ((Stage) anchorPane.getScene().getWindow()).close();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
