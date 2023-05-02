package com.Projekt.Animace;

import com.Projekt.Cube.Kosticka;

public class CasovacAnimaci extends Thread {
    public static boolean casovacIsRunning = false;
    static int i = 0;
    Kosticka[][][] kosticka;
    String postupRotaci;
    VlaknaAnimaci v;

    public CasovacAnimaci(Kosticka[][][] kosticka, String postupRotaci) {
        setDaemon(true);
        this.kosticka = kosticka;
        this.postupRotaci = postupRotaci;
    }

    public static boolean isCasovacIsRunning() {
        return casovacIsRunning;
    }

    public static void setCasovacIsRunning(boolean casovacIsRunning) {
        CasovacAnimaci.casovacIsRunning = casovacIsRunning;
    }

    @Override
    public void run() {
        //šachovnice U2 D' D' R2 L' L' F2 B' B'
        //kříž U F B' L2 U2 L2 F' B U2 L2 U
        // kostka v kostce F L F U' R U F2 L2 U' L' B D' B' L2 U
        //kostka v kostce v kostce  U' L' U' F' R2 B' R F U B2 U B' L U' F U R F'

        //postupRotaci = "y y ";
        setCasovacIsRunning(true);
        System.out.println(postupRotaci);
        postupRotaci = postupRotaci.replaceAll("y2", "y y");
        System.out.println(postupRotaci);
        v = new VlaknaAnimaci(kosticka, postupRotaci);
        while (postupRotaci.length() > i) {
            metoda();
        }
        i = 0;
        setCasovacIsRunning(false);
    }

    public void metoda() {
        if (Animace.isRunning()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            v.run();
        }
    }
}
