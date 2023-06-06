package co.edu.uptc.modelo;

import java.util.ArrayList;

public class Movil {
    private String marca;
    private String modelo;
    private ArrayList<Chip> chips;

    public Movil(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        chips = new ArrayList<Chip>();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void agregarChip(Chip chip) {
        chips.add(chip);
    }

    @Override
    public String toString() {
        return "Celular [marca=" + marca + ", modelo=" + modelo + ", chips=" + chips + "]";
    }
}
