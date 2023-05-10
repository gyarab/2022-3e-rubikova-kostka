/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Projekt.MainGui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Tom
 */
public class NastaveniController implements Initializable {


    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private ImageView imageView;

    @FXML
    private Label label;
    @FXML
    private RadioButton modra_radio;
    @FXML
    private RadioButton cervena_radio;
    @FXML
    private RadioButton zluta_radio;
    @FXML
    private RadioButton zelena_radio;
    @FXML
    private RadioButton bila_radio;
    @FXML
    private RadioButton oranzova_radio;

    @FXML
    private MenuButton resButton;

    @FXML
    private Label errorLabel;

    @FXML
    private MenuButton languageButton;
    
    @FXML
    private TextArea upozorneni;




    @FXML
    private String[] getBarvy() {
        String[] barvy = new String[54];
        for (Node element : AnchorPane.getChildren()) {
            if (element instanceof GridPane) {

                zpracujGridPane((GridPane) element, barvy);
            }
        }
        kontrola(barvy);
        return barvy;
    }
    
    private boolean kontrola(String[] barvy) {
        boolean bezChyby = true;
        upozorneni.setText("");
        Map<String, Integer> dict = new HashMap<String, Integer>();
        dict.put("cervenabarva", 0);
        dict.put("modrabarva", 0);
        dict.put("bilabarva", 0);
        dict.put("zelenabarva", 0);
        dict.put("zlutabarva", 0);
        dict.put("oranzovabarva", 0);

        for (int i = 0; i < barvy.length; i++) {
            if (!dict.containsKey(barvy[i])) {
                continue;
            }
            int pocet = dict.get(barvy[i]);
            pocet++;
            dict.put(barvy[i], pocet);

        }
        for (String barva : dict.keySet()) {
            int pocet = dict.get(barva);
            if (pocet != 9) {
                upozorneni.appendText("Chyba: " + barva + " je v poli " + pocet + "x a má být 9x\n");
                bezChyby = false;
            }

        }
        return bezChyby;
    }

    private void zpracujGridPane(GridPane g, String[] barvy) {
        for (Node element : g.getChildren()) {
            if (element instanceof Button) {

                zpracujButton((Button) element, barvy);
            }
        }
    }

    private void zpracujButton(Button b, String[] barvy) {
        String id = b.getId();
        String[] casti = id.split("_");
        int cislo = Integer.parseInt(casti[1]);
        for (String cssClass : b.getStyleClass()) {
            if (!cssClass.equals("kostka") && !cssClass.equals("button")) {
                barvy[cislo - 1] = cssClass;
                return;
            }
        }
    }

    @FXML
    private void zmenBarvuAction(ActionEvent event) {
        Button tlacitko = (Button) event.getTarget();
        tlacitko.getStyleClass().clear();
        tlacitko.getStyleClass().add("kostka");
        tlacitko.getStyleClass().add(getAktualniBarva());
    }

    private String getAktualniBarva() {
        if (modra_radio.isSelected()) {
            return "modrabarva";
        }
        if (cervena_radio.isSelected()) {
            return "cervenabarva";
        }
        if (zluta_radio.isSelected()) {
            return "zlutabarva";
        }
        if (zelena_radio.isSelected()) {
            return "zelenabarva";
        }
        if (bila_radio.isSelected()) {
            return "bilabarva";
        }
        if (oranzova_radio.isSelected()) {
            return "oranzovabarva";
        }
        return "";
    }

    @FXML
    private void zpet(ActionEvent event) {
        Parent root = ContentManager.switchContent("Lobby");
        CubeApp.mainStage.getScene().setRoot(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(ContentManager.currLanguage == "czech") languageButton.setText("Čeština");
        else languageButton.setText("English");
        buildMenuButton();
    }

    public void buildMenuButton(){
        MenuItem hd = new MenuItem("1280x720");
        MenuItem fhd = new MenuItem("1920x1080");
        MenuItem shd = new  MenuItem("2560x1440");

        MenuItem english = new MenuItem("English");
        MenuItem czech = new MenuItem("Čeština");

        czech.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContentManager.currLanguage = "czech";

                Parent root = ContentManager.switchContent("Nastaveni");
                CubeApp.mainStage.getScene().setRoot(root);
            }
        });

        english.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContentManager.currLanguage = "english";
                Parent root = ContentManager.switchContent("Nastaveni");
                CubeApp.mainStage.getScene().setRoot(root);
            }
        });

        hd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    CubeApp.setResolution(1280,720);
                    resButton.setText("1280x720");
                } catch (Exception e) {
                    errorLabel.setText(e.getMessage());
                }
            }
        });
        fhd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    CubeApp.setResolution(1920,1080);
                    resButton.setText("1920x1080");
                } catch (Exception e) {
                    errorLabel.setText(e.getMessage());
                }
            }
        });
        shd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    CubeApp.setResolution(2560,1440);
                    resButton.setText("2560x1440");
                } catch (Exception e) {
                    errorLabel.setText(e.getMessage());
                }
            }
        });
        languageButton.getItems().clear();
        languageButton.getItems().addAll(english,czech);
        resButton.getItems().clear();
        resButton.getItems().addAll(hd,fhd,shd);
        resButton.setText((int)CubeApp.ACTUAL_WIDTH.get() + "x" + (int)CubeApp.ACTUAL_HEIGHT.get());
    }
}