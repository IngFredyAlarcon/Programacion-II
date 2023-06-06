package co.edu.uptc.modelo;

public class Cuadrado extends FiguraGeometrica {
    private int lado;
    private int area;

    public Cuadrado() {
    }

    public void calcularArea() {
        this.area = lado * lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

}
