package com.Projekt.Animace;

import com.Projekt.Cube.Kosticka;
import javafx.scene.transform.Rotate;

class AnimaceUD extends Animace {
    public AnimaceUD(Kosticka kosticka, String smer) {
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
        } else {
            if (smer == "R") {
                rotace1();
            } else if (smer == "L") {
                rotace2();
            }
        }
    }

    @Override
    public void rotace1() {
        float cilovyUhelD = -90;
        if (aktualniUhelPosunu == cilovyUhelD + rychlostRotace) {
            stop();
        }
        aktualniUhelPosunu = aktualniUhelPosunu - rychlostRotace;
        addRotate(kosticka.getMeshView(), Rotate.Y_AXIS, -rychlostRotace);
    }

    @Override
    public void rotace2() {
        float cilovyUhelD = 90;
        if (aktualniUhelPosunu == cilovyUhelD - rychlostRotace) {
            stop();
        }
        aktualniUhelPosunu = aktualniUhelPosunu + rychlostRotace;
        addRotate(kosticka.getMeshView(), Rotate.Y_AXIS, rychlostRotace);
    }

    @Override
    public void rotaceStredu1() {
        float cilovyUhelD = -90;
        if (aktualniUhelPosunu == cilovyUhelD + rychlostRotace) {
            stop();
        }
        aktualniUhelPosunu = aktualniUhelPosunu - rychlostRotace;
        addRotate(kosticka.getMeshView(), Rotate.Y_AXIS, -rychlostRotace);
    }

    @Override
    public void rotaceStredu2() {
        float cilovyUhelD = 90;
        if (aktualniUhelPosunu == cilovyUhelD - rychlostRotace) {
            stop();
        }
        aktualniUhelPosunu = aktualniUhelPosunu + rychlostRotace;
        addRotate(kosticka.getMeshView(), Rotate.Y_AXIS, rychlostRotace);
    }

}
