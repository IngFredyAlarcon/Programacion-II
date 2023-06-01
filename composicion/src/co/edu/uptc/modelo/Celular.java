package co.edu.uptc.modelo;

public class Celular {
    private String marca;
    private String modelo;
    private Bateria bateria;

    public Celular(String marca, String modelo, int capacidad, String marcaBateria) {
        this.marca = marca;
        this.modelo = modelo;
        bateria = new Bateria(capacidad, marcaBateria);
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

    @Override
    public String toString() {
        return "Celular [marca=" + marca + ", modelo=" + modelo + ", bateria=" + bateria + "]";
    }

}
