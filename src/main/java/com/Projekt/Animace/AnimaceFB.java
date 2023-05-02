package com.Projekt.Animace;

import com.Projekt.Cube.Kosticka;
import javafx.scene.transform.Rotate;

public class AnimaceFB extends Animace {
    public AnimaceFB(Kosticka kosticka, String smer) {
        this.kosticka = kosticka;
        this.smer = smer;
    }

    @Override
    public void handle(long l) {
        if (isStred) {
            if (smer == "R") {
                rotaceStredu1();
            } else if (smer == "L") {
                rotaceStredu2();
            }
        } else if (smer == "R") {
            rotace1();
        } else if (smer == "L") {
            rotace2();
        }
    }

    //https://stackoverflow.com/questions/40816108/how-can-i-know-if-an-animationtimer-is-running
    @Override
    public void rotace1() {
        float cilovyUhelD = 90;
        if (aktualniUhelPosunu == cilovyUhelD - rychlostRotace) {
            stop();
        }
        aktualniUhelPosunu = aktualniUhelPosunu + rychlostRotace;
        addRotate(kosticka.getMeshView(), Rotate.Z_AXIS, rychlostRotace);
    }

    @Override
    public void rotace2() {
        float cilovyUhelD = -90;
        if (aktualniUhelPosunu == cilovyUhelD + rychlostRotace) {
            stop();
        }
        aktualniUhelPosunu = aktualniUhelPosunu - rychlostRotace;
        addRotate(kosticka.getMeshView(), Rotate.Z_AXIS, -rychlostRotace);
    }

    @Override
    public void rotaceStredu1() {
        float cilovyUhelD = +90;
        if (aktualniUhelPosunu == cilovyUhelD - rychlostRotace) {
            stop();
        }
        aktualniUhelPosunu = aktualniUhelPosunu + rychlostRotace;
        addRotate(kosticka.getMeshView(), Rotate.Z_AXIS, rychlostRotace);
    }

    @Override
    public void rotaceStredu2() {
        float cilovyUhelD = -90;
        if (aktualniUhelPosunu == cilovyUhelD + rychlostRotace) {
            stop();
        }
        aktualniUhelPosunu = aktualniUhelPosunu - rychlostRotace;
        addRotate(kosticka.getMeshView(), Rotate.Z_AXIS, -rychlostRotace);
    }


}