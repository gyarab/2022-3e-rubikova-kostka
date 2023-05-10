package com.Projekt.MainGui;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class CubeApp extends Application {
    public static Stage mainStage;
    public static DoubleProperty ACTUAL_WIDTH = new SimpleDoubleProperty();;
    public static DoubleProperty ACTUAL_HEIGHT = new SimpleDoubleProperty();;
    public static double MAX_WIDTH;
    public static double MAX_HEIGHT;
    public static double MIN_WIDTH = 1280;
    public static double MIN_HEIGHT = 720;
    static Rectangle2D screenBounds;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        mainStage = stage;

        screenBounds = Screen.getPrimary().getVisualBounds();

        MAX_WIDTH = screenBounds.getWidth();
        MAX_HEIGHT = screenBounds.getHeight();

        ACTUAL_WIDTH.set(MAX_WIDTH);
        ACTUAL_HEIGHT.set(MAX_HEIGHT);

        stage.setResizable(false);

        stage.setMaxWidth(MAX_WIDTH);
        stage.setMaxHeight(MAX_HEIGHT);

        setResolution(ACTUAL_WIDTH.get(),ACTUAL_HEIGHT.get());

        stage.setMinWidth(MIN_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);

        Scene scene = new Scene(new Region());
        setSceneContent(scene);

        stage.setScene(scene);
        stage.show();

        dimensionsSync();
    }

    public void setSceneContent(Scene scene) {
        Parent root = ContentManager.switchContent("Lobby");
        scene.setRoot(root);
    }

    public void dimensionsSync(){
        mainStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            ACTUAL_WIDTH.set(newValue.doubleValue());
            System.out.println(ACTUAL_WIDTH + "x" + ACTUAL_HEIGHT);
        });

        mainStage.heightProperty().addListener((observable, oldValue, newValue) -> {
            ACTUAL_HEIGHT.set(newValue.doubleValue());
            System.out.println(ACTUAL_WIDTH + "x" + ACTUAL_HEIGHT);
        });
        }
    @Override
    public void stop() throws Exception {

    }

    public static void setResolution(double width, double height) {
        if(mainStage.isFullScreen()) throw new RuntimeException("NOT AVAILABLE IN FULLSCREEN MODE");
        if(width> MAX_WIDTH || height > MAX_WIDTH ) throw new RuntimeException("UNAVAILABLE");
        else{
            mainStage.setWidth(width);
            mainStage.setHeight(height);
        }
    }
}

