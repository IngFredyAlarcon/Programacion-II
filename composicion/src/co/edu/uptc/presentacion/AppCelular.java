package co.edu.uptc.presentacion;

import java.util.Scanner;

import co.edu.uptc.control.CelularControl;
import co.edu.uptc.modelo.Celular;

public class AppCelular {
    static String marca;
    static String modelo;
    static int capacidadBateria;
    static String marcaBateria;
    static CelularControl cc = new CelularControl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Datos del Celular");
        System.out.println("Digite la marca: ");
        marca = sc.next();
        System.out.println("Digite el modelo: ");
        modelo = sc.next();
        System.out.println("--------------------------------------------");
        System.out.println("Datos de la Bateria");
        System.out.println("Digite la marca de la bateria: ");
        marcaBateria = sc.next();
        System.out.println("Digite la capacidad de la bateria: ");
        capacidadBateria = sc.nextInt();

        cc.crearCelular(marca, modelo, capacidadBateria, marcaBateria);
        System.out.println("--------------------------------------------");
        System.out.println("Datos del Celular ");
        System.out.println(cc.mostrarDatos());
        System.out.println("--------------------------------------------");
        System.out.println("Datos del Celular despues de eliminar");
        cc.eliminarCelular();// Eliminando el objeto
        try {
            System.out.println(cc.mostrarDatos());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("El objeto solicitado es nulo!!!");
        }

        // Enviando el objeto c1 al garbage colector
        // c1 = null;
        // System.gc();// Garbage collection
        // System.out.println("Después de enviar el objeto c1 al garbage colector");
        // System.out.println(c1.toString()); // Sí se invoca así lanzará una exception
        // nullPointer
    }
}
