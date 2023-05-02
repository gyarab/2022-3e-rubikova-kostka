package com.Projekt.Cube;

import javafx.scene.Group;

public class Kostka {
    public Kosticka[][][] kosticka = new Kosticka[3][3][3];
    float positionX;
    float positionY;
    float positionZ;
    float width;
    float height;
    float depth;
    float velikostMezer;
    Group group;
    Bod[][][] anchorPoint = new Bod[3][3][3];

    public Kostka(float positionX, float positionY, float positionZ, float width, float height, float depth, float velikostMezer, Group group) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.velikostMezer = velikostMezer;
        this.group = group;
        float a = 0;
        float b = 0;
        float c = 0;

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    a = positionX - (width + velikostMezer);
                    break;
                case 1:
                    a = positionX;
                    break;
                case 2:
                    a = positionX + (width + velikostMezer);
                    break;
            }
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        c = positionZ - (depth + velikostMezer);
                        break;
                    case 1:
                        c = positionZ;
                        break;
                    case 2:
                        c = positionZ + (depth + velikostMezer);
                        break;
                }
                for (int k = 0; k < 3; k++) {
                    switch (k) {
                        case 0:
                            b = positionY + (height + velikostMezer);
                            break;
                        case 1:
                            b = positionY;
                            break;
                        case 2:
                            b = positionY - (height + velikostMezer);
                            break;
                    }

                    anchorPoint[i][j][k] = new Bod(a, b, c);
                }
            }
        }
        inicialisujKostky();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    group.getChildren().add(kosticka[i][j][k].getMeshView());
                    //kosticka[i][j][k].getCoords();
                }
            }
        }
    }

    public void inicialisujKostky() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    kosticka[i][j][k] = new Kosticka(width, height, depth, anchorPoint[i][j][k].getCoordinateX(),
                            anchorPoint[i][j][k].getCoordinateY(), anchorPoint[i][j][k].getCoordinateZ(), "texturaUniResized1.png");
                    kosticka[i][j][k].setId(i + " " + j + " " + k);
                    kosticka[i][j][k].setArrayCords(i + " " + j + " " + k);
                }
            }
        }
    }


}
