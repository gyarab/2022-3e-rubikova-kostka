package com.Projekt.MainGui;

import com.Projekt.Animace.VlaknaAnimaci;
import com.Projekt.Cube.CubeSceneBuilder;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class KostkaController implements Initializable {//https://stackoverflow.com/questions/24606392/how-to-resize-a-javafx-3d-subscene
    public static VlaknaAnimaci vlaknaAnimaci;

    Stage popUpStage = new Stage();
        //   String pohyby = Test.uprava();
    com.Projekt.SolvingPetr.Kostka cube = new com.Projekt.SolvingPetr.Kostka();
    String a = cube.generatorZamichani();

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane subScenePane;
    CubeSceneBuilder csb;
    @FXML
    private Button timerButton;

    @FXML
    private Label movesLabel;

    Integer moves = 0;
    @FXML
    public Label timerLabel;
    long startTime;
    long endTime;

    ScheduledExecutorService executor;

    //TODO zatím se správně neukončuje ale na funkčnost to nemá vliv

    public Boolean isTimerRunning = false;

    @FXML
    void timerOnAction(ActionEvent event) {

        //TODO pridat zastavení při složené kostce
        if(!isTimerRunning){
            executor = Executors.newScheduledThreadPool(1);
            startTime = System.currentTimeMillis();
            isTimerRunning = true;
            csb.isTimerRunning = isTimerRunning;
            executor.scheduleAtFixedRate(helloRunnable, 0, 5, TimeUnit.MILLISECONDS);
            timerButton.setText("Restart Timer");
        }
        else {
            isTimerRunning = false;
            csb.isTimerRunning = isTimerRunning;
            executor.shutdown();
            System.out.println(executor.isShutdown());
            timerButton.setText("Start Timer");
            timerLabel.setText("00.00.000");
            movesLabel.setText("Tahu: 0");
            csb.timerMoves.clear();
        }
    }
    Runnable helloRunnable = new Runnable() {
        public void run() {
            Platform.runLater(() -> {
                if(isTimerRunning){
                    endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime);
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.MINUTES.toSeconds(minutes);
                    long millis = elapsedTime - TimeUnit.MINUTES.toMillis(minutes) - TimeUnit.SECONDS.toMillis(seconds);
                    String formattedTime = String.format("%02d:%02d:%03d", minutes, seconds, millis);
                    timerLabel.setText(formattedTime);
                }
            });
        }
    };

    public static String inputString; // uživatelem zadaný string. Po zmáčknutí ENTR ;P

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        csb = new CubeSceneBuilder();
        SubScene cubeSubScene = csb.buildSceneCubescene(subScenePane, anchorPane);
        subScenePane.getChildren().add(cubeSubScene);
        csb.timerMoves.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                if(isTimerRunning){
                    Platform.runLater(() -> {
                        movesLabel.setText("Tahu: " + change.getList().size());
                    });
                    System.out.println("tim"+change.getList());
                }
            }
        });
        CubeSceneBuilder.allMoves.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                    System.out.println("all"+change.getList());

            }
        });
       Platform.runLater(new Runnable() {
           @Override public void run() {
               csb.syncMoves();
           }
       });
    }
    @FXML
    void moveButtonsOnAction(ActionEvent event) {//https://stackoverflow.com/questions/25409044/javafx-multiple-buttons-to-same-handler
        Button button = (Button) event.getSource();
        String s = button.getText();
        csb.spusteniOtoceni(s);
    }

    @FXML
    void zamichatButtonOnAction(ActionEvent event) {
        csb.spustStrojovePohyby(a);
        cube.zamichat(a);
    }

    @FXML
    void navratDoLobbyOnAction(ActionEvent event) {
        Parent root = ContentManager.switchContent("Lobby");
        CubeApp.mainStage.getScene().setRoot(root);
        ContentManager.isTutorial = false;
    }

    @FXML
    void solveOnAction(ActionEvent event) {
        if (!ContentManager.isTutorial) {
            popUpStage.close();
            Text text = new Text();
            String b = com.Projekt.SolvingPetr.Test.vypsat(a);
     /*   String y = " ";
        a = cube.bileHrany();
        y = a;
        String z = "\nTutoriálový postup\n    bílé hrany: " + a;
        a = cube.bilyKriz();
        z += "\n    bílý kříž: " + a;
        y += a;
        a = cube.bilaVrstva();
        z += "\n    bílá vrstva: " + a;
        y += a;
        a = cube.vlozeniKraju();
        z += "\n    vložení krajů: " + a;
        y += a;
        a = cube.zlutyKriz();
        z += "\n    žlutý kříž: " + a;
        y += a;
        a = cube.zlutaVrstva();
        z += "\n    žlutá vrstva: " + a;
        y += a;
        a = cube.zbytek();
        z += "\n    zbytek: " + a;
        y += a;
        y = y.trim().replaceAll(" +", " ");
        y = y.replaceAll("y2", "y y");
        y += " ";

      */
            csb.spustStrojovePohyby(b);


            text.setText("Zamíchání: " + a + "\nŘešení: " + b);
            text.setX(50);
            text.setY(50);

            Pane d = new Pane();
            d.getChildren().add(text);
            Scene c = new Scene(d, 500, 200);

            popUpStage.setScene(c);
            popUpStage.show();
        } else {
            //TODO zde algorytmus pro učení
        }
    }
}

