package com.Projekt.SolvingPetr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) {
        Kostka kostka = new Kostka();
        String str = kostka.generatorZamichani();
        System.out.println(vypsat(str));
    }
    public static String vypsat(String zamichani) {
        Kostka cube = new Kostka();
        cube.zamichat(zamichani);
        String a;
        String b;

        a = cube.bileHrany() + " ";
        b = a;
        a = cube.bilyKriz() + " ";
        b += a;
        a = cube.bilaVrstva() + " ";
        b += a;
        a = cube.vlozeniKraju() + " ";
        b += a;
        a = cube.zlutyKriz() + " ";
        b += a;
        a = cube.zlutaVrstva() + " ";
        b += a;
        a = cube.zbytek() + " ";
        b += a;

        b = cube.optimalizovat(b);
        b += "  ";
        b = b.trim().replaceAll(" +", " ");
        b = b.trim().replaceAll("y2", "y y");
        return b;
    }
}
