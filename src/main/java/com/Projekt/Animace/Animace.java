package com.Projekt.Animace;

import com.Projekt.Cube.Kosticka;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public abstract class Animace extends AnimationTimer {
    volatile static boolean running;
    static volatile int rychlostRotace = 5;// pouze coločíselné dělitele 90
    Boolean isStred = false;
    String smer;
    Kosticka kosticka;
    float aktualniUhelPosunu = 0; // o kolik stupnu se už potočil

    public static boolean isRunning() {
        return running;
    }

    //https://stackoverflow.com/questions/40124238/javafx-rotate-an-object-without-turning-the-axis
    public static void setRychlostRotace(int rychlostRotace) {// poze coločíselné dělitele 90
        if (rychlostRotace > 0) {
            Animace.rychlostRotace = rychlostRotace;
        } else {
            System.out.println("Rychlost rotace musí být kladné celé číslo");
        }
    }

    @Override
    public void start() {
        super.start();
        running = true;
    }

    @Override
    public void stop() {
        super.stop();
        running = false;
    }

    public void setStred(Boolean stred) {
        isStred = stred;
    }

    public abstract void rotace1();

    public abstract void rotace2();

    public abstract void rotaceStredu1();

    public abstract void rotaceStredu2();

    public void addRotate(Node node, Point3D rotationAxis, double angle) {
        ObservableList<Transform> transforms = node.getTransforms();
        try {
            for (Transform t : transforms) {
                rotationAxis = t.inverseDeltaTransform(rotationAxis);
            }
        } catch (NonInvertibleTransformException ex) {
            throw new IllegalStateException(ex);
        }
        transforms.add(new Rotate(angle, rotationAxis));
    }
}
