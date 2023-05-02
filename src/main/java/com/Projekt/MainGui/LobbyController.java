/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Projekt.MainGui;

import com.Projekt.Cube.Kostka;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class LobbyController implements Initializable {
    @FXML
    private Button kostkaButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView logoImageView;
    @FXML
    private AnchorPane logo;
    Stage popUpNapoveda  = new Stage();

    @FXML
    private void nastaveni(ActionEvent event) {
        changeContent("Nastaveni");
    }

    @FXML
    private void uceni(ActionEvent event) {
        changeContent("Uceni");
    }

    @FXML
    private void napoveda(ActionEvent event) {

        //changeContent("Napoveda");


    //    popUpNapoveda.close();

        Text text = new Text();
        text.setText("TADY BUDE MNOU NAPSANÁ NÁPOVĚDA");
        text.setX(50);
        text.setY(50);
        Button button = new Button();
        button.setText("<-");

        Pane d = new Pane();
        d.getChildren().add(button);
        d.getChildren().add(text);
        Scene c = new Scene(d, 500,200);

        button.setOnAction(e -> {
            popUpNapoveda.close();
        });

        popUpNapoveda.setTitle("Nápověda");
        popUpNapoveda.setScene(c);
        popUpNapoveda.show();
    }

    @FXML
    void kostkaOnAction(ActionEvent event) {
        changeContent("Kostka");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageSync();
    }
    public void imageSync(){
        logo.widthProperty().addListener((observable, oldValue, newValue) -> {
                logoImageView.setFitWidth(newValue.doubleValue() * 0.99);
        });
        logo.heightProperty().addListener((observable, oldValue, newValue) -> {
                logoImageView.setFitHeight(newValue.doubleValue() * 0.99);
       });
    }
    //https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
    private void changeContent(String fileName) {
        Parent parent = ContentManager.switchContent(fileName);
        CubeApp.mainStage.getScene().setRoot(parent);
    }
}
