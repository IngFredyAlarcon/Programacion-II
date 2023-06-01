package co.edu.uptc.control;

import co.edu.uptc.modelo.Celular;

public class CelularControl {
    private Celular c1;

    public CelularControl() {
    }

    public void crearCelular(String marca, String modelo, int capacidadBateria, String marcaBateria) {
        c1 = new Celular(marca, modelo, capacidadBateria, marcaBateria);
    }

    public String mostrarDatos() {
        return c1.toString();
    }

    public void eliminarCelular() {
        c1 = null;
    }
}
