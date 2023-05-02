package com.Projekt.SolvingPetr;

public class KostickaBarva {
    private char barva;
    private char smer;

    public KostickaBarva(char barva, char smer) {
        this.barva = barva;
        this.smer = smer;
    }

    public char getBarva() {
        return barva;
    }

    public void setBarva(char barva) {
        this.barva = barva;
    }

    public char getSmer() {
        return smer;
    }

    public void setSmer(char smer) {
        this.smer = smer;
    }
}
