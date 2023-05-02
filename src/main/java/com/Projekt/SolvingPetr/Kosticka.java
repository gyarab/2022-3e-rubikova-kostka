package com.Projekt.SolvingPetr;

public class Kosticka {
    private final int x;
    private final int y;
    private final int z;
    private final boolean roh;
    private final boolean hrana;
    KostickaBarva[] barvy;

    public Kosticka(int x, int y, int z, boolean roh, boolean hrana, KostickaBarva[] barvy) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.roh = roh;
        this.hrana = hrana;
        this.barvy = barvy;
    }

    public KostickaBarva[] getBarvy() {
        return barvy;
    }

    public void setBarvy(KostickaBarva[] barvy) {
        this.barvy = barvy;
    }

    public boolean isHrana() {
        return hrana;
    }

    public boolean isRoh() {
        return roh;
    }

    public boolean isBilyRoh() {
        if (roh) {
            return (barvy[0].getBarva() == 'W' || barvy[1].getBarva() == 'W' || barvy[2].getBarva() == 'W');
        }
        return false;
    }

    public char getSmerBarvy(char barva) {
        for (int i = 0; i < barvy.length; i++) {
            if (barvy[i].getBarva() == barva) {
                return barvy[i].getSmer();
            }
        }
        return 'A';
    }

    public char getBarvaSmeru(char smer) {
        for (int i = 0; i < barvy.length; i++) {
            if (barvy[i].getSmer() == smer) {
                return barvy[i].getBarva();
            }
        }
        return 'A';
    }

    public char orientHrana(int x, int y) {
        if (hrana) {
            if (x == 0) {
                return 'L';
            } else if (x == 1) {
                if (y == 0) {
                    return 'F';
                } else {
                    return 'B';
                }
            } else {
                return 'R';
            }
        }
        return 'A';
    }
}