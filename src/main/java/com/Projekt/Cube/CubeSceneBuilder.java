package com.Projekt.Cube;

import com.Projekt.Animace.Animace;
import com.Projekt.Animace.CasovacAnimaci;
import com.Projekt.Animace.VlaknaAnimaci;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import java.util.concurrent.atomic.AtomicReference;

public class CubeSceneBuilder {
    public static String colorSeen = "white";
    public static VlaknaAnimaci vlaknaAnimaci;
    public final DoubleProperty aktualniUhelX = new SimpleDoubleProperty(0); // ukládá úhel rotace
    public final DoubleProperty aktualniUhelY = new SimpleDoubleProperty(0);
    public Group cubeGroup;
    Kostka k;
    double bodDotekuX; // kde myš klikne
    double bodDotekuY;
    double uhelTahuX = 0; // pod jakým úhlem táhnete
    double uhelTahuY = 0;
    public static ObservableList<String> allMoves = FXCollections.observableArrayList();
    public  ObservableList<String> timerMoves = FXCollections.observableArrayList();

    public Boolean isTimerRunning = false;

    public void syncMoves(){
        allMoves.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                if(isTimerRunning){
                    timerMoves.add((String) change.getList().get(change.getList().size()-1));
                }
            }
        });
    }

    CasovacAnimaci casovacAnimaci;
    //   String pohyby = Test.uprava();
    com.Projekt.SolvingPetr.Kostka cube = new com.Projekt.SolvingPetr.Kostka();
    String a = cube.generatorZamichani();
    Pane subScenePane;
    SubScene cubeSubScene;

    public SubScene buildSceneCubescene(Pane subScenePane, Pane root){
        this.subScenePane = subScenePane;
        cubeGroup = buildGroup();
        cubeSubScene = buildScene(cubeGroup);
        initMouseControl(cubeGroup, cubeSubScene);
        //initKeyboardControl(scene);
        initKeyboardControl(root);
        vlaknaAnimaci = new VlaknaAnimaci(k.kosticka);

        return cubeSubScene;
    }

    public void spustStrojovePohyby(String pohyby) {
        casovacAnimaci = new CasovacAnimaci(k.kosticka, pohyby);
        casovacAnimaci.start();
    }

    private Group buildGroup() {
        Group alfaGroup = new Group();
        alfaGroup.getChildren().add(new AmbientLight());// přidá všeobecné světlo
        k = new Kostka(0, 0, 0, 100, 100, 100, 0, alfaGroup);//POZICE NELZE MENIT ABY SE NEPODELALI ANIMACE
        // přidá kostku. kostka se přidá automaticky v konstruktoru možná časem přerozdělit
        return alfaGroup;// vrátí sestavenou betaGroup
    }

    private SubScene buildScene(Group group) {// vytvoří obsah scény
        SubScene scene = new SubScene(group,subScenePane.heightProperty().getValue(),subScenePane.widthProperty().getValue(),true,null);// přidá GROUP obsahující KOSTKU
        scene.heightProperty().bind(subScenePane.heightProperty());
        scene.widthProperty().bind(subScenePane.widthProperty());
        scene.setFill(Color.LIGHTGRAY);
        scene.setCamera(buildCamera());
        return scene;
    }

    private void initMouseControl(Group group, SubScene scene) { // metoda na otáčení myší
        AtomicReference<Double> relativniX = new AtomicReference<>(aktualniUhelX.get() % 360);
        AtomicReference<Double> relativniY = new AtomicReference<>(aktualniUhelY.get() % 360);

        Rotate RotaceX;// rotace nodu
        Rotate RotaceY;
        group.getTransforms().addAll(// přidám pohyby
                RotaceX = new Rotate(0, Rotate.X_AXIS), //  úhel a osa rotace
                RotaceY = new Rotate(0, Rotate.Y_AXIS)
        );// při změne  RotaceX/Y se začne hýbat

        RotaceX.angleProperty().bind(aktualniUhelX);// na základě změny uhelX/Y začátek rotace
        RotaceY.angleProperty().bind(aktualniUhelY);

        scene.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                bodDotekuX = event.getSceneX();// nastaví bod kliknutí
                bodDotekuY = event.getSceneY();
                uhelTahuX = aktualniUhelX.get();// srovná aktuálí úhel s úhlem tahu aby se pokračovalo od aktuální rotace a né z nulové polohy
                uhelTahuY = aktualniUhelY.get();
                //k.rotaceF();
            }
        });
        scene.setOnMouseDragged(event -> {//lambda konvene... nvm jak to fachá ale funguje to
            if (event.getButton() == MouseButton.PRIMARY) {
                if ((uhelTahuX - (bodDotekuY - event.getSceneY())) <= 90 && (uhelTahuX - (bodDotekuY - event.getSceneY())) >= -90) {
                    aktualniUhelX.set(uhelTahuX - (bodDotekuY - event.getSceneY()));//začne měnit aktualniUhel. "odečte" myší uraženou vzdálenost od úhlu
                }
                aktualniUhelY.set(uhelTahuY + (bodDotekuX - event.getSceneX())); // puvodni pozice +/- pozice na kterou myš dojela
                relativniX.set(aktualniUhelX.get() % 360);
                relativniY.set(aktualniUhelY.get() % 360);

                colorSeen = viewPoint(relativniX.get(), relativniY.get());
            }
        });
        scene.addEventHandler(ScrollEvent.SCROLL, event -> {// ovládání "zoomu" kamery
            double delta = event.getDeltaY();
            group.translateZProperty().set(group.getTranslateZ() + delta);
        });
    }

    private void initKeyboardControl(Pane root) {//https://stackoverflow.com/questions/33224161/how-do-i-run-a-function-on-a-specific-key-press-in-javafx
        root.setOnKeyPressed(e -> {
            if (!CasovacAnimaci.isCasovacIsRunning()) {
                if (!Animace.isRunning()) {
                    if (e.getCode() == KeyCode.Y) {
                        vlaknaAnimaci.rotaceU("L");
                        vlaknaAnimaci.rotaceS("L");
                        vlaknaAnimaci.rotaceD("L");
                        //timerMoves.add("F");
                        System.out.println("spusteniS");
                    }
                    if (e.getCode() == KeyCode.C) {
                        vlaknaAnimaci.rotaceU("R");
                        vlaknaAnimaci.rotaceS("R");
                        vlaknaAnimaci.rotaceD("R");
                        //timerMoves.add("F");
                        System.out.println("spusteniS");
                    }
                    if (e.getCode() == KeyCode.F) {
                        vlaknaAnimaci.rotaceF("R");
                        //timerMoves.add("F");
                        System.out.println("spusteniF");
                    }
                    if (e.getCode() == KeyCode.G) {
                        vlaknaAnimaci.rotaceF("L");
                        //timerMoves.add("F'");
                        System.out.println("spusteniG");
                    }
                    if (e.getCode() == KeyCode.B) {
                        vlaknaAnimaci.rotaceB("R");
                        //timerMoves.add("B");
                        System.out.println("spusteniB");
                    }
                    if (e.getCode() == KeyCode.N) {
                        vlaknaAnimaci.rotaceB("L");
                        //timerMoves.add("B'");
                        System.out.println("spusteniN");
                    }
                    if (e.getCode() == KeyCode.R) {
                        vlaknaAnimaci.rotaceR("R");
                        //timerMoves.add("R");
                        System.out.println("spusteniR");
                    }
                    if (e.getCode() == KeyCode.T) {
                        vlaknaAnimaci.rotaceR("L");
                        //timerMoves.add("R'");
                        System.out.println("spusteniT");
                    }
                    if (e.getCode() == KeyCode.L) {
                        vlaknaAnimaci.rotaceL("R");
                        //timerMoves.add("L");
                        System.out.println("spusteniL");
                    }
                    if (e.getCode() == KeyCode.P) {
                        vlaknaAnimaci.rotaceL("L");
                        //timerMoves.add("L'");
                        System.out.println("spusteniP");
                    }
                    if (e.getCode() == KeyCode.U) {
                        vlaknaAnimaci.rotaceU("R");
                        //timerMoves.add("U");
                        System.out.println("spusteniU");
                    }
                    if (e.getCode() == KeyCode.H) {
                        vlaknaAnimaci.rotaceU("L");
                        //timerMoves.add("U'");
                        System.out.println("spusteniH");
                    }
                    if (e.getCode() == KeyCode.D) {
                        vlaknaAnimaci.rotaceD("R");
                        //timerMoves.add("D");
                        System.out.println("spusteniD");
                    }
                    if (e.getCode() == KeyCode.X) {
                        vlaknaAnimaci.rotaceD("L");
                        //timerMoves.add("D'");
                        System.out.println("spusteniX");
                    }
               /*     if (e.getCode() == KeyCode.A) {
                        spustStrojovePohyby(pohyby);
                        System.out.println("spusteniA");
                    }

                */

                } else if (Animace.isRunning()) {
                    System.out.println("Běží otočení");
                }
            } else if (CasovacAnimaci.isCasovacIsRunning()) {
                System.out.println("Běží řešení");
            }
        });
    }

    private Camera buildCamera() {
        //TODO omezit přiblížení a vzdálení kamery
        Camera camera = new PerspectiveCamera(true);
        camera.translateZProperty().set(-800);
        camera.setNearClip(1);// kdy se zobrazí objekty v prostoru - jaká dálka
        camera.setFarClip(100000);
        return camera;
    }


public void timerMovesAdd(String move){
        if(isTimerRunning){
            timerMoves.add(move);
        }
}


    private String viewPoint(Double x, Double y) {
        String aroundY = viewPointAroundY(y);
        String aroundX = viewPointAroundX(x);

        String viewPoint = aroundX.concat(aroundY);

        return viewPoint;
    }

    private String viewPointAroundX(Double x) {
        if (x > 45) {
            return "green";
        } else if (x < -45) {
            return "blue";
        }
        return "";
    }
    private String viewPointAroundY(Double y) {
        if (y > 0) {
            double angle = y % 360;
            if (angle >= 0 && angle < 45) return "white";
            else if (angle >= 45 && angle < 135) return "orange";
            else if (angle >= 135 && angle < 225) return "yellow";
            else if (angle >= 225 && angle < 315) return "red";
            else if (angle >= 315 && angle < 360) return "white";
        } else if (y < 0) {
            double angle = y % 360;
            if (angle <= 0 && angle > -45) return "white";
            else if (angle <= -45 && angle > -135) return "red";
            else if (angle <= -135 && angle > -225) return "yellow";
            else if (angle <= -225 && angle > -315) return "orange";
            else if (angle <= -315 && angle > -360) return "white";
        } else if (y == 0) return "white";
        return "";
    }

    public void spusteniOtoceni(String keyTyped) {
        switch (keyTyped) {
            case "U" -> {
                vlaknaAnimaci.rotaceU("R");
                //timerMoves.add("U");
            }
            case "U'" -> {
                vlaknaAnimaci.rotaceU("L");
                //timerMoves.add("U'");
            }
            case "D" -> {
                vlaknaAnimaci.rotaceD("R");
                //timerMoves.add("D");
            }
            case "D'" -> {
                vlaknaAnimaci.rotaceD("L");
                //timerMoves.add("D'");
            }
            case "R" -> {
                vlaknaAnimaci.rotaceR("R");
                //timerMoves.add("R");
            }
            case "R'" -> {
                vlaknaAnimaci.rotaceR("L");
                //timerMoves.add("R'");
            }
            case "L" -> {
                vlaknaAnimaci.rotaceL("R");
                //timerMoves.add("L");
            }
            case "L'" -> {
                vlaknaAnimaci.rotaceL("L");
                //timerMoves.add("L");
            }
            case "F" -> {
                vlaknaAnimaci.rotaceF("R");
                //timerMoves.add("F");
            }
            case "F'" -> {
                vlaknaAnimaci.rotaceF("L");
                //timerMoves.add("F'");
            }
            case "B" -> {
                vlaknaAnimaci.rotaceB("R");
                //timerMoves.add("B");
            }
            case "B'" -> {
                vlaknaAnimaci.rotaceB("L");
                //timerMoves.add("B");
            }
        }
    }
}
