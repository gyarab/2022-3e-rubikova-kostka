
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Projekt.MainGui;

import com.Projekt.Cube.CubeSceneBuilder;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Tom
 */
public class UceniController implements Initializable {
    @FXML
    private ImageView movesImageView;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private void zpatky(ActionEvent event) {
        Parent root = ContentManager.switchContent("Lobby");
        CubeApp.mainStage.getScene().setRoot(root);
    }

    @FXML
    private void spustitSetOnAction(ActionEvent event) {
        Parent root = ContentManager.switchContent("Kostka");
        CubeApp.mainStage.getScene().setRoot(root);
        ContentManager.isTutorial = true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        adjustSizes();
    }
    public void adjustSizes(){
        if (CubeApp.ACTUAL_WIDTH.get() >= 2550){
            movesImageView.setFitWidth(630);
            anchorPane.getStylesheets().remove(1);
            anchorPane.getStylesheets().add(getClass().getResource("css/TextSheet1.css").toString());
            System.out.println(anchorPane.getStylesheets());
            Platform.runLater(() -> {
                System.out.println(movesImageView.getFitWidth());
            });
        }
        else if(CubeApp.ACTUAL_WIDTH.get() < 2549 && CubeApp.ACTUAL_WIDTH.get() > 1500){
            movesImageView.setFitWidth(472);
            anchorPane.getStylesheets().remove(1);
            anchorPane.getStylesheets().add(getClass().getResource("css/TextSheet2.css").toString());
            System.out.println(anchorPane.getStylesheets());
            Platform.runLater(() -> {
                System.out.println(movesImageView.getFitWidth());
            });
        }else{
            movesImageView.setFitWidth(315);
            anchorPane.getStylesheets().remove(1);
            anchorPane.getStylesheets().add(getClass().getResource("css/TextSheet3.css").toString());
            System.out.println(anchorPane.getStylesheets());
            Platform.runLater(() -> {
                System.out.println(movesImageView.getFitWidth());
            });
        }
    }
}