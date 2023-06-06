package co.edu.uptc.modelo;

public class Circulo extends FiguraGeometrica {
    private int radio;
    private float area;
    public final float pi = 3.1416f;

    public Circulo() {
    }

    public void calcularArea() {
        this.area = pi * (radio * radio);
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

}
