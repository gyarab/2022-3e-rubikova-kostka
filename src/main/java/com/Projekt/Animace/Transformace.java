package com.Projekt.Animace;

import com.Projekt.Cube.Kosticka;

class Transformace {
    public static void rotateSP(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                tmp[z][y] = k[z][y][1];
            }
        }
        k[0][0][1] = tmp[0][2];
        k[0][1][1] = tmp[1][2];
        k[0][2][1] = tmp[2][2];

        k[1][0][1] = tmp[0][1];
        k[1][1][1] = tmp[1][1];
        k[1][2][1] = tmp[2][1];

        k[2][0][1] = tmp[0][0];
        k[2][1][1] = tmp[1][0];
        k[2][2][1] = tmp[2][0];
        aktualizaceOfArrayCords(k);
    }

    public static void rotateSL(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                tmp[z][y] = k[z][y][1];
            }
        }
        k[0][0][1] = tmp[2][0];
        k[0][1][1] = tmp[1][0];
        k[0][2][1] = tmp[0][0];

        k[1][0][1] = tmp[2][1];
        k[1][1][1] = tmp[1][1];
        k[1][2][1] = tmp[0][1];

        k[2][0][1] = tmp[2][2];
        k[2][1][1] = tmp[1][2];
        k[2][2][1] = tmp[0][2];
        aktualizaceOfArrayCords(k);
    }


    public static void rotaceFP(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int x = 0; x < 3; x++) {
            System.arraycopy(k[x][0], 0, tmp[x], 0, 3);
        }
        k[0][0][0] = tmp[2][0];
        k[1][0][0] = tmp[2][1];
        k[2][0][0] = tmp[2][2];
        k[0][0][1] = tmp[1][0];
        k[1][0][1] = tmp[1][1];
        k[2][0][1] = tmp[1][2];
        k[0][0][2] = tmp[0][0];
        k[1][0][2] = tmp[0][1];
        k[2][0][2] = tmp[0][2];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceFL(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int x = 0; x < 3; x++) {
            System.arraycopy(k[x][0], 0, tmp[x], 0, 3);
        }
        k[0][0][0] = tmp[0][2];
        k[1][0][0] = tmp[0][1];
        k[2][0][0] = tmp[0][0];
        k[0][0][1] = tmp[1][2];
        k[1][0][1] = tmp[1][1];
        k[2][0][1] = tmp[1][0];
        k[0][0][2] = tmp[2][2];
        k[1][0][2] = tmp[2][1];
        k[2][0][2] = tmp[2][0];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceBP(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int x = 0; x < 3; x++) {
            System.arraycopy(k[x][2], 0, tmp[x], 0, 3);
        }
        k[0][2][0] = tmp[2][0];
        k[1][2][0] = tmp[2][1];
        k[2][2][0] = tmp[2][2];
        k[0][2][1] = tmp[1][0];
        k[1][2][1] = tmp[1][1];
        k[2][2][1] = tmp[1][2];
        k[0][2][2] = tmp[0][0];
        k[1][2][2] = tmp[0][1];
        k[2][2][2] = tmp[0][2];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceBL(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int x = 0; x < 3; x++) {
            System.arraycopy(k[x][2], 0, tmp[x], 0, 3);
        }
        k[0][2][0] = tmp[0][2];
        k[1][2][0] = tmp[0][1];
        k[2][2][0] = tmp[0][0];
        k[0][2][1] = tmp[1][2];
        k[1][2][1] = tmp[1][1];
        k[2][2][1] = tmp[1][0];
        k[0][2][2] = tmp[2][2];
        k[1][2][2] = tmp[2][1];
        k[2][2][2] = tmp[2][0];
        aktualizaceOfArrayCords(k);
    }


    public static void rotaceRP(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            System.arraycopy(k[2][y], 0, tmp[y], 0, 3);
        }
        k[2][0][0] = tmp[2][0];
        k[2][1][0] = tmp[2][1];
        k[2][2][0] = tmp[2][2];

        k[2][0][1] = tmp[1][0];
        k[2][1][1] = tmp[1][1];
        k[2][2][1] = tmp[1][2];

        k[2][0][2] = tmp[0][0];
        k[2][1][2] = tmp[0][1];
        k[2][2][2] = tmp[0][2];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceRL(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            System.arraycopy(k[2][y], 0, tmp[y], 0, 3);
        }
        k[2][0][0] = tmp[0][2];
        k[2][1][0] = tmp[0][1];
        k[2][2][0] = tmp[0][0];

        k[2][0][1] = tmp[1][2];
        k[2][1][1] = tmp[1][1];
        k[2][2][1] = tmp[1][0];

        k[2][0][2] = tmp[2][2];
        k[2][1][2] = tmp[2][1];
        k[2][2][2] = tmp[2][0];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceLP(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            System.arraycopy(k[0][y], 0, tmp[y], 0, 3);
        }
        k[0][0][0] = tmp[2][0];
        k[0][1][0] = tmp[2][1];
        k[0][2][0] = tmp[2][2];

        k[0][0][1] = tmp[1][0];
        k[0][1][1] = tmp[1][1];
        k[0][2][1] = tmp[1][2];

        k[0][0][2] = tmp[0][0];
        k[0][1][2] = tmp[0][1];
        k[0][2][2] = tmp[0][2];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceLL(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            System.arraycopy(k[0][y], 0, tmp[y], 0, 3);
        }
        k[0][0][0] = tmp[0][2];
        k[0][1][0] = tmp[0][1];
        k[0][2][0] = tmp[0][0];

        k[0][0][1] = tmp[1][2];
        k[0][1][1] = tmp[1][1];
        k[0][2][1] = tmp[1][0];

        k[0][0][2] = tmp[2][2];
        k[0][1][2] = tmp[2][1];
        k[0][2][2] = tmp[2][0];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceUL(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                tmp[z][y] = k[z][y][2];
            }
        }
        k[0][0][2] = tmp[2][0];
        k[0][1][2] = tmp[1][0];
        k[0][2][2] = tmp[0][0];

        k[1][0][2] = tmp[2][1];
        k[1][1][2] = tmp[1][1];
        k[1][2][2] = tmp[0][1];

        k[2][0][2] = tmp[2][2];
        k[2][1][2] = tmp[1][2];
        k[2][2][2] = tmp[0][2];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceUR(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                tmp[z][y] = k[z][y][2];
            }
        }
        k[0][0][2] = tmp[0][2];
        k[0][1][2] = tmp[1][2];
        k[0][2][2] = tmp[2][2];

        k[1][0][2] = tmp[0][1];
        k[1][1][2] = tmp[1][1];
        k[1][2][2] = tmp[2][1];

        k[2][0][2] = tmp[0][0];
        k[2][1][2] = tmp[1][0];
        k[2][2][2] = tmp[2][0];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceDL(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                tmp[z][y] = k[z][y][0];
            }
        }
        k[0][0][0] = tmp[2][0];
        k[0][1][0] = tmp[1][0];
        k[0][2][0] = tmp[0][0];

        k[1][0][0] = tmp[2][1];
        k[1][1][0] = tmp[1][1];
        k[1][2][0] = tmp[0][1];

        k[2][0][0] = tmp[2][2];
        k[2][1][0] = tmp[1][2];
        k[2][2][0] = tmp[0][2];
        aktualizaceOfArrayCords(k);
    }

    public static void rotaceDR(Kosticka[][][] k) {
        Kosticka[][] tmp = new Kosticka[3][3];
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                tmp[z][y] = k[z][y][0];
            }
        }
        k[0][0][0] = tmp[0][2];
        k[0][1][0] = tmp[1][2];
        k[0][2][0] = tmp[2][2];

        k[1][0][0] = tmp[0][1];
        k[1][1][0] = tmp[1][1];
        k[1][2][0] = tmp[2][1];

        k[2][0][0] = tmp[0][0];
        k[2][1][0] = tmp[1][0];
        k[2][2][0] = tmp[2][0];
        aktualizaceOfArrayCords(k);
    }

    public static void aktualizaceOfArrayCords(Kosticka[][][] k) {
        for (int x = 0; x < k.length; x++) {
            for (int y = 0; y < k.length; y++) {
                for (int z = 0; z < k.length; z++) {
                    k[x][y][z].setArrayCords(x + " " + y + " " + z);
                }
            }
        }
    }
}
