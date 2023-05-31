package co.edu.uptc.control;

import java.util.Random;

import co.edu.uptc.modelo.Estudiante;

public class EstudianteControl {
    private String codigoAleatorio;
    private Estudiante estudiante1;
    private String codigo;

    public EstudianteControl() {
    }

    public String generarCodigo() {
        Random rdn = new Random();
        int min = 1000000; // valor mínimo de 7 dígitos
        int max = 9999999; // valor máximo de 7 dígitos
        this.codigoAleatorio = "abc" + (rdn.nextInt(max - min + 1) + min);
        return this.codigoAleatorio;
    }

    public void crearEstudiante(String nombre, String apellido, int edad, String programa) {
        codigo = generarCodigo();
        estudiante1 = new Estudiante(nombre, apellido, edad, codigo, programa);
    }

    public String mostrarDatosEstudiante() {
        return estudiante1.toString();
    }

}
