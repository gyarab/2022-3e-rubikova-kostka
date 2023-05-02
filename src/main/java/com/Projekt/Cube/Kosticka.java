package com.Projekt.Cube;

import com.Projekt.Animace.Animace;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class Kosticka {//možnost extendovat Node
    String id;
    String arrayCords;
    String textura;
    float width;
    float height;
    float depth;
    float positionX;
    float positionY;
    float positionZ;
    MeshView meshView;
    TriangleMesh mesh;
    private double bodDotekuX;
    private double bodDotekuY;
    private double bodTahuX;
    private double bodTahuY;


    public Kosticka(float width, float height, float depth, float positionX, float positionY, float positionZ, String textura) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.textura = textura;
        pripravMeshView();
        initiateMouseControl();

    }




    public void pripravMeshView() {
        meshView = vytvorMesh(width, height, depth, positionX, positionY, positionZ);
        meshView.setCullFace(CullFace.FRONT);
        meshView.setMaterial(nactiTexturu(textura));
    }

    public MeshView vytvorMesh(float width, float height, float depth, float positionX, float positionY, float positionZ) {
        mesh = new TriangleMesh();
        mesh.getPoints().addAll(
                positionX - width / 2, positionY + height / 2, positionZ - depth / 2,      //P0
                positionX + width / 2, positionY + height / 2, positionZ - depth / 2,    //P1
                positionX - width / 2, positionY - height / 2, positionZ - depth / 2,    //P2
                positionX + width / 2, positionY - height / 2, positionZ - depth / 2,  //P3
                positionX - width / 2, positionY + height / 2, positionZ + depth / 2,        //P4
                positionX + width / 2, positionY + height / 2, positionZ + depth / 2,      //P5
                positionX - width / 2, positionY - height / 2, positionZ + depth / 2,      //P6
                positionX + width / 2, positionY - height / 2, positionZ + depth / 2     //P7
        );
        mesh.getTexCoords().addAll(
                0.25f, 0,       //T0
                0.5f, 0,        //T1
                0, 0.25f,       //T2
                0.25f, 0.25f,   //T3
                0.5f, 0.25f,    //T4
                0.75f, 0.25f,   //T5
                1, 0.25f,       //T6
                0, 0.5f,        //T7
                0.25f, 0.5f,    //T8
                0.5f, 0.5f,     //T9
                0.75f, 0.5f,    //T10
                1, 0.5f,        //T11
                0.25f, 0.75f,   //T12
                0.5f, 0.75f     //T13
        );
        mesh.getFaces().addAll(
                5, 1, 4, 0, 0, 3     //P5,T1 ,P4,T0  ,P0,T3
                , 5, 1, 0, 3, 1, 4    //P5,T1 ,P0,T3  ,P1,T4
                , 0, 3, 4, 2, 6, 7    //P0,T3 ,P4,T2  ,P6,T7
                , 0, 3, 6, 7, 2, 8    //P0,T3 ,P6,T7  ,P2,T8
                , 1, 4, 0, 3, 2, 8    //P1,T4 ,P0,T3  ,P2,T8
                , 1, 4, 2, 8, 3, 9    //P1,T4 ,P2,T8  ,P3,T9
                , 5, 5, 1, 4, 3, 9    //P5,T5 ,P1,T4  ,P3,T9
                , 5, 5, 3, 9, 7, 10   //P5,T5 ,P3,T9  ,P7,T10
                , 4, 6, 5, 5, 7, 10   //P4,T6 ,P5,T5  ,P7,T10
                , 4, 6, 7, 10, 6, 11  //P4,T6 ,P7,T10 ,P6,T11
                , 3, 9, 2, 8, 6, 12   //P3,T9 ,P2,T8  ,P6,T12
                , 3, 9, 6, 12, 7, 13  //P3,T9 ,P6,T12 ,P7,T13
        );
        MeshView output = new MeshView(mesh);
        return output;
    }

    public Material nactiTexturu(String name) {
        Image image = new Image(getClass().getResourceAsStream(name));
        PhongMaterial material = new PhongMaterial();
        material.setSpecularColor(Color.TRANSPARENT);
        material.setDiffuseMap(image);
        return material;
    }

    public MeshView getMeshView() {
        return meshView;
    }

    public void setTextura(String textura) {
        this.textura = textura;
        meshView.setMaterial(nactiTexturu(textura));
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setArrayCords(String arrayCords) {
        this.arrayCords = arrayCords;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                '}';
    }
    public void initiateMouseControl() {
        meshView.setOnMousePressed(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                bodDotekuX = mouseEvent.getSceneX();
                bodDotekuY = mouseEvent.getSceneY();
                //System.out.println(bodDotekuX);
                //System.out.println(bodDotekuY);
                //System.out.println("Kliklo to!!!");

            }
        });
        meshView.setOnMouseReleased(event -> {//lambda konvene... nvm jak to fachá ale funguje to
            if (event.getButton() == MouseButton.SECONDARY) {
                bodTahuX = event.getSceneX();
                bodTahuY = event.getSceneY();
                //System.out.println(bodTahuX);
                //System.out.println(bodTahuY);
                //System.out.println("tahlo to!!!");

                double x = Math.abs(bodDotekuX - bodTahuX);
                double y = Math.abs(bodDotekuY - bodTahuY);
                String aktualniBarva = CubeSceneBuilder.colorSeen;
                if (!Animace.isRunning()) {// optimalizace je žádoucí

                    if (x > y) {//jestli pohyb do stran

                        if (bodDotekuX < bodTahuX) {// pohyb myší doprava

                            switch (aktualniBarva) {
                                case "white":
                                    if (arrayCords.charAt(2) == '0') {
                                        switch (arrayCords.charAt(4)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceF("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceF("R");
                                        }
                                    }
                                    break;
                                case "yellow":
                                    if (arrayCords.charAt(2) == '2') {
                                        switch (arrayCords.charAt(4)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceB("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceB("L");
                                        }
                                    }
                                    break;
                                case "red":
                                    if (arrayCords.charAt(0) == '0') {
                                        switch (arrayCords.charAt(4)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceL("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceL("L");
                                        }
                                    }
                                    break;
                                case "orange":
                                    if (arrayCords.charAt(0) == '2') {
                                        switch (arrayCords.charAt(4)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceR("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceR("R");
                                        }
                                    }
                                    break;
                                case "greenwhite":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                        }
                                    }
                                    break;
                                case "greenyellow":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                        }
                                    }
                                    break;
                                case "greenred":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                        }
                                    }
                                    break;
                                case "greenorange":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                        }
                                    }
                                    break;
                                case "bluewhite":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                        }
                                    }
                                    break;
                                case "blueyellow":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                        }
                                    }
                                    break;
                                case "bluered":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                        }
                                    }
                                    break;
                                case "blueorange":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                        }
                                    }
                                    break;

                            }
                        } else if (bodDotekuX > bodTahuX) {//pohyb myší doleva
                            switch (aktualniBarva) {
                                case "white":
                                    if (arrayCords.charAt(2) == '0') {
                                        switch (arrayCords.charAt(4)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceF("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceF("L");
                                        }
                                    }
                                    break;
                                case "yellow":
                                    if (arrayCords.charAt(2) == '2') {
                                        switch (arrayCords.charAt(4)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceB("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceB("R");
                                        }
                                    }
                                    break;
                                case "red":

                                    if (arrayCords.charAt(0) == '0') {
                                        switch (arrayCords.charAt(4)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceL("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceL("R");
                                        }
                                    }
                                    break;
                                case "orange":
                                    if (arrayCords.charAt(0) == '2') {
                                        switch (arrayCords.charAt(4)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceR("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceR("L");
                                        }
                                    }
                                    break;
                                case "greenwhite":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                        }
                                    }
                                    break;
                                case "greenyellow":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                        }
                                    }
                                    break;
                                case "greenred":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                        }
                                    }
                                    break;
                                case "greenorange":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                        }
                                    }
                                    break;
                                case "bluewhite":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                        }
                                    }
                                    break;
                                case "blueyellow":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                        }
                                    }
                                    break;
                                case "bluered":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                        }
                                    }
                                    break;
                                case "blueorange":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                        }
                                    }
                                    break;
                            }
                        }
                    } else if (x < y) {//pohyb myší vertikálně
                        
                        if (bodDotekuY < bodTahuY) {//pohyb nahoru
                            switch (aktualniBarva) {
                                case "white":
                                    if (arrayCords.charAt(2) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceF("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceF("R");
                                        }
                                    }
                                    break;
                                case "yellow":
                                    if (arrayCords.charAt(2) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceB("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceB("R");
                                        }
                                    }
                                    break;
                                case "red":
                                    if (arrayCords.charAt(0) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceL("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceL("R");
                                        }
                                    }
                                    break;
                                case "orange":
                                    if (arrayCords.charAt(0) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceR("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceR("R");
                                        }
                                    }
                                    break;
                                case "greenwhite":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                        }
                                    }
                                    break;
                                case "greenyellow":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                        }
                                    }
                                    break;
                                case "greenred":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                        }
                                    }
                                    break;
                                case "greenorange":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                        }
                                    }
                                    break;
                                case "bluewhite":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                        }
                                    }
                                    break;
                                case "blueyellow":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                        }
                                    }
                                    break;
                                case "bluered":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                        }
                                    }
                                    break;
                                case "blueorange":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                        }
                                    }
                                    break;
                            }
                        } else if (bodDotekuY > bodTahuY) {//pohyb dolu
                            switch (aktualniBarva) {
                                case "white":
                                    if (arrayCords.charAt(2) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceF("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceF("L");
                                        }
                                    }
                                    break;
                                case "yellow":
                                    if (arrayCords.charAt(2) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceB("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceB("L");
                                        }
                                    }
                                    break;
                                case "red":
                                    if (arrayCords.charAt(0) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceL("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceL("L");
                                        }
                                    }
                                    break;
                                case "orange":
                                    if (arrayCords.charAt(0) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceR("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceR("L");
                                        }
                                    }
                                    break;
                                case "greenwhite":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                        }
                                    }
                                    break;
                                case "greenyellow":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                        }
                                    }
                                    break;
                                case "greenred":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                        }
                                    }
                                    break;
                                case "greenorange":
                                    if (arrayCords.charAt(4) == '2') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceU("R");
                                        }
                                    }
                                    break;
                                case "bluewhite":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                        }
                                    }
                                    break;
                                case "blueyellow":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(0)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                        }
                                    }
                                    break;
                                case "bluered":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                        }
                                    }
                                    break;
                                case "blueorange":
                                    if (arrayCords.charAt(4) == '0') {
                                        switch (arrayCords.charAt(2)) {
                                            case '0' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("R");
                                            case '2' -> CubeSceneBuilder.vlaknaAnimaci.rotaceD("L");
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        });
    }
}
