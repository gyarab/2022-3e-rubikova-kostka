package com.Projekt.Animace;

import com.Projekt.Cube.CubeSceneBuilder;
import com.Projekt.Cube.Kosticka;

import static com.Projekt.Animace.Transformace.*;

public class VlaknaAnimaci extends Thread {
    Kosticka[][][] kosticka;
    String postupRotaci;

    public VlaknaAnimaci(Kosticka[][][] kosticka, String postupRotaci) {
        setDaemon(true);
        this.kosticka = kosticka;
        this.postupRotaci = postupRotaci;
    }

    public VlaknaAnimaci(Kosticka[][][] kosticka) {
        this.kosticka = kosticka;
    }

    public static void rotaceFBjedneKosticky(Kosticka kosticka, String smer, Boolean isStred) {
        AnimaceFB animaceFB = new AnimaceFB(kosticka, smer);
        animaceFB.setStred(isStred);
        animaceFB.start();
    }

    @Override
    public void run() {
        metoda();
    }

    public void metoda() {
        String s = postupRotaci;
        if (s.charAt(CasovacAnimaci.i) == 'F') {
            if (Character.toString(s.charAt(CasovacAnimaci.i + 1)).equals("'")) {
                if (!Animace.isRunning()) {
                    rotaceF("L");
                    System.out.println("spusteniG");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == '2') {
                if (!Animace.isRunning()) {
                    rotaceF("R");
                    System.out.println("spusteniF");

                    rotaceF("R");
                    System.out.println("spusteniF");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == ' ') {
                if (!Animace.isRunning()) {
                    rotaceF("R");
                    System.out.println("spusteniF");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 2;
            }
        } else if (s.charAt(CasovacAnimaci.i) == 'B') {
            if (Character.toString(s.charAt(CasovacAnimaci.i + 1)).equals("'")) {
                if (!Animace.isRunning()) {
                    rotaceB("R");
                    System.out.println("spusteniB");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == '2') {
                if (!Animace.isRunning()) {
                    rotaceB("L");
                    System.out.println("spusteniN");

                    rotaceB("L");
                    System.out.println("spusteniN");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == ' ') {
                if (!Animace.isRunning()) {
                    rotaceB("L");
                    System.out.println("spusteniN");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 2;
            }
        } else if (s.charAt(CasovacAnimaci.i) == 'L') {
            if (Character.toString(s.charAt(CasovacAnimaci.i + 1)).equals("'")) {
                if (!Animace.isRunning()) {
                    rotaceL("R");
                    System.out.println("spusteniL");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == '2') {
                if (!Animace.isRunning()) {
                    rotaceL("L");
                    System.out.println("spusteniP");

                    rotaceL("L");
                    System.out.println("spusteniP");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == ' ') {
                if (!Animace.isRunning()) {
                    rotaceL("L");
                    System.out.println("spusteniP");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 2;
            }
        } else if (s.charAt(CasovacAnimaci.i) == 'R') {
            if (Character.toString(s.charAt(CasovacAnimaci.i + 1)).equals("'")) {
                if (!Animace.isRunning()) {
                    rotaceR("L");
                    System.out.println("spusteniT");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == '2') {
                if (!Animace.isRunning()) {
                    rotaceR("R");
                    System.out.println("spusteniR");

                    rotaceR("R");
                    System.out.println("spusteniR");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == ' ') {
                if (!Animace.isRunning()) {
                    rotaceR("R");
                    System.out.println("spusteniR");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 2;
            }

        } else if (s.charAt(CasovacAnimaci.i) == 'U') {
            if (Character.toString(s.charAt(CasovacAnimaci.i + 1)).equals("'")) {
                if (!Animace.isRunning()) {
                    rotaceU("R");
                    System.out.println("spusteniU");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == '2') {
                if (!Animace.isRunning()) {
                    rotaceU("L");
                    System.out.println("spusteniH");

                    rotaceU("L");
                    System.out.println("spusteniH");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == ' ') {
                if (!Animace.isRunning()) {
                    rotaceU("L");
                    System.out.println("spusteniH");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 2;
            }
        } else if (s.charAt(CasovacAnimaci.i) == 'D') {
            if (Character.toString(s.charAt(CasovacAnimaci.i + 1)).equals("'")) {
                if (!Animace.isRunning()) {
                    rotaceD("L");
                    System.out.println("spusteniX");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == '2') {
                if (!Animace.isRunning()) {
                    rotaceD("R");
                    System.out.println("spusteniD");

                    rotaceD("R");
                    System.out.println("spusteniD");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == ' ') {
                if (!Animace.isRunning()) {
                    rotaceD("R");
                    System.out.println("spusteniD");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 2;
            }
        } else if (s.charAt(CasovacAnimaci.i) == 'y') {
            if (Character.toString(s.charAt(CasovacAnimaci.i + 1)).equals("'")) {
                if (!Animace.isRunning()) {
                    rotaceU("R");
                    rotaceS("R");
                    rotaceD("R");
                    System.out.println("spusteni y");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 3;
            } else if (s.charAt(CasovacAnimaci.i + 1) == ' ') {
                if (!Animace.isRunning()) {
                    rotaceU("L");
                    rotaceS("L");
                    rotaceD("L");
                    System.out.println("spusteni y");
                }
                CasovacAnimaci.i = CasovacAnimaci.i + 2;
            }
        }
    }

    public void roteceRLjedneKosticky(Kosticka kosticka, String smer, Boolean isStred) {
        AnimaceRL animaceRL = new AnimaceRL(kosticka, smer);
        animaceRL.setStred(isStred);
        animaceRL.start();
    }

    public void roteceUDjedneKosticky(Kosticka kosticka, String smer, Boolean isStred) {
        AnimaceUD animaceRL = new AnimaceUD(kosticka, smer);
        animaceRL.setStred(isStred);
        animaceRL.start();
    }

    public void rotaceF(String smer) {// R- Doprava L- doleva
        rotaceFBjedneKosticky(kosticka[0][0][0], smer, false);
        rotaceFBjedneKosticky(kosticka[0][0][1], smer, false);
        rotaceFBjedneKosticky(kosticka[0][0][2], smer, false);

        rotaceFBjedneKosticky(kosticka[1][0][0], smer, false);
        rotaceFBjedneKosticky(kosticka[1][0][1], smer, true);
        rotaceFBjedneKosticky(kosticka[1][0][2], smer, false);

        rotaceFBjedneKosticky(kosticka[2][0][0], smer, false);
        rotaceFBjedneKosticky(kosticka[2][0][1], smer, false);
        rotaceFBjedneKosticky(kosticka[2][0][2], smer, false);
        if (smer == "R") {
            CubeSceneBuilder.allMoves.add("F");
            rotaceFP(kosticka);
        } else if (smer == "L") {
            CubeSceneBuilder.allMoves.add("F'");
            rotaceFL(kosticka);
        }
    }

    public void rotaceB(String smer) {
        rotaceFBjedneKosticky(kosticka[0][2][0], smer, false);
        rotaceFBjedneKosticky(kosticka[0][2][1], smer, false);
        rotaceFBjedneKosticky(kosticka[0][2][2], smer, false);

        rotaceFBjedneKosticky(kosticka[1][2][0], smer, false);
        rotaceFBjedneKosticky(kosticka[1][2][1], smer, true);
        rotaceFBjedneKosticky(kosticka[1][2][2], smer, false);

        rotaceFBjedneKosticky(kosticka[2][2][0], smer, false);
        rotaceFBjedneKosticky(kosticka[2][2][1], smer, false);
        rotaceFBjedneKosticky(kosticka[2][2][2], smer, false);
        if (smer == "R") {
            rotaceBP(kosticka);
            CubeSceneBuilder.allMoves.add("B");
        } else if (smer == "L") {
            CubeSceneBuilder.allMoves.add("B'");
            rotaceBL(kosticka);
        }
    }

    public void rotaceR(String smer) {
        roteceRLjedneKosticky(kosticka[2][0][0], smer, false);
        roteceRLjedneKosticky(kosticka[2][1][0], smer, false);
        roteceRLjedneKosticky(kosticka[2][2][0], smer, false);

        roteceRLjedneKosticky(kosticka[2][0][1], smer, false);
        roteceRLjedneKosticky(kosticka[2][1][1], smer, true);
        roteceRLjedneKosticky(kosticka[2][2][1], smer, false);

        roteceRLjedneKosticky(kosticka[2][0][2], smer, false);
        roteceRLjedneKosticky(kosticka[2][1][2], smer, false);
        roteceRLjedneKosticky(kosticka[2][2][2], smer, false);
        if (smer == "R") {
            rotaceRP(kosticka);
            CubeSceneBuilder.allMoves.add("R");
        } else if (smer == "L") {
            CubeSceneBuilder.allMoves.add("R'");
            rotaceRL(kosticka);
        }
    }

    public void rotaceL(String smer) {
        roteceRLjedneKosticky(kosticka[0][0][0], smer, false);
        roteceRLjedneKosticky(kosticka[0][1][0], smer, false);
        roteceRLjedneKosticky(kosticka[0][2][0], smer, false);

        roteceRLjedneKosticky(kosticka[0][0][1], smer, false);
        roteceRLjedneKosticky(kosticka[0][1][1], smer, true);
        roteceRLjedneKosticky(kosticka[0][2][1], smer, false);

        roteceRLjedneKosticky(kosticka[0][0][2], smer, false);
        roteceRLjedneKosticky(kosticka[0][1][2], smer, false);
        roteceRLjedneKosticky(kosticka[0][2][2], smer, false);
        if (smer == "R") {
            rotaceLP(kosticka);
            CubeSceneBuilder.allMoves.add("L");
        } else if (smer == "L") {
            CubeSceneBuilder.allMoves.add("L'");
            rotaceLL(kosticka);
        }
    }

    public void rotaceU(String smer) {
        roteceUDjedneKosticky(kosticka[0][0][2], smer, false);
        roteceUDjedneKosticky(kosticka[0][1][2], smer, false);
        roteceUDjedneKosticky(kosticka[0][2][2], smer, false);

        roteceUDjedneKosticky(kosticka[1][0][2], smer, false);
        roteceUDjedneKosticky(kosticka[1][1][2], smer, true);
        roteceUDjedneKosticky(kosticka[1][2][2], smer, false);

        roteceUDjedneKosticky(kosticka[2][0][2], smer, false);
        roteceUDjedneKosticky(kosticka[2][1][2], smer, false);
        roteceUDjedneKosticky(kosticka[2][2][2], smer, false);
        if (smer == "R") {
            rotaceUR(kosticka);
            CubeSceneBuilder.allMoves.add("U");
        } else if (smer == "L") {
            CubeSceneBuilder.allMoves.add("U'");
            rotaceUL(kosticka);
        }
    }

    public void rotaceD(String smer) {
        roteceUDjedneKosticky(kosticka[0][0][0], smer, false);
        roteceUDjedneKosticky(kosticka[0][1][0], smer, false);
        roteceUDjedneKosticky(kosticka[0][2][0], smer, false);

        roteceUDjedneKosticky(kosticka[1][0][0], smer, false);
        roteceUDjedneKosticky(kosticka[1][1][0], smer, true);
        roteceUDjedneKosticky(kosticka[1][2][0], smer, false);

        roteceUDjedneKosticky(kosticka[2][0][0], smer, false);
        roteceUDjedneKosticky(kosticka[2][1][0], smer, false);
        roteceUDjedneKosticky(kosticka[2][2][0], smer, false);
        if (smer == "R") {
            rotaceDR(kosticka);
            CubeSceneBuilder.allMoves.add("D");
        } else if (smer == "L") {
            rotaceDL(kosticka);
            CubeSceneBuilder.allMoves.add("D'");
        }
    }

    public void rotaceS(String smer) {
        roteceUDjedneKosticky(kosticka[0][0][1], smer, false);
        roteceUDjedneKosticky(kosticka[0][1][1], smer, false);
        roteceUDjedneKosticky(kosticka[0][2][1], smer, false);

        roteceUDjedneKosticky(kosticka[1][0][1], smer, false);
        roteceUDjedneKosticky(kosticka[1][1][1], smer, true);
        roteceUDjedneKosticky(kosticka[1][2][1], smer, false);

        roteceUDjedneKosticky(kosticka[2][0][1], smer, false);
        roteceUDjedneKosticky(kosticka[2][1][1], smer, false);
        roteceUDjedneKosticky(kosticka[2][2][1], smer, false);
        if (smer == "R") {
            rotateSP(kosticka);
            CubeSceneBuilder.allMoves.add("y");
        } else if (smer == "L") {
            CubeSceneBuilder.allMoves.add("y'");
            rotateSL(kosticka);
        }
    }
}
