package com.Projekt.Cube;

class Bod {
    float coordinateX;
    float coordinateY;
    float coordinateZ;

    public Bod(float coordinateX, float coordinateY, float coordinateZ) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
    }

    public float getCoordinateX() {
        return coordinateX;
    }

    public float getCoordinateY() {
        return coordinateY;
    }

    public float getCoordinateZ() {
        return coordinateZ;
    }

    @Override
    public String toString() {
        return "Bod{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                ", coordinateZ=" + coordinateZ +
                '}';
    }
}
