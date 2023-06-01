package co.edu.uptc.presentacion;

import java.util.Scanner;

import co.edu.uptc.control.EstudianteControl;

public class AppEstudiante {
    static String nombre;
    static String apellido;
    static int edad;
    static String programa;
    private static EstudianteControl ec1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ec1 = new EstudianteControl();
        System.out.println("Digite el nombre del estudiante");
        nombre = sc.next();
        System.out.println("Digite el apellido del estudiante");
        apellido = sc.next();
        System.out.println("Digite la edad del estudiante");
        edad = sc.nextInt();
        System.out.println("Digite el programa al que del estudiante");
        programa = sc.next();

        // Enviamos datos al controlador
        ec1.crearEstudiante(nombre, apellido, edad, programa);

        // Recibimos datos desde el controlador
        System.out.println("Los datos del Estudiante son" + ec1.mostrarDatosEstudiante());
        sc.close();
    }

}
