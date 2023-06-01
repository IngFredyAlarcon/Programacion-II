package co.edu.uptc.modelo;

public class Bateria {
    private int capacidad;
    private String marca;

    public Bateria(int capacidad, String marca) {
        this.capacidad = capacidad;
        this.marca = marca;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Bateria [capacidad=" + capacidad + ", marca=" + marca + "]";
    }

}
