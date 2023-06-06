package co.edu.uptc.presentacion;

import co.edu.uptc.control.*;

import java.util.Scanner;

public class AppCelularChip {
    static String marca;
    static String modelo;
    static String tipoChip;
    static String proveedorChip;
    static String descripcionChip;
    static CelularChipControl cc = new CelularChipControl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Datos del Celular");
        System.out.println("Digite la marca: ");
        marca = sc.next();
        System.out.println("Digite el modelo: ");
        modelo = sc.next();
        System.out.println("--------------------------------------------");
        System.out.println("Datos de los Chips");
        System.out.println("Digite el tipo de chip: ");
        tipoChip = sc.next();
        System.out.println("Digite el proveedor del chip: ");
        proveedorChip = sc.next();
        System.out.println("Digite la descripcion del chip: ");
        descripcionChip = sc.next();
        cc.crearMovil(marca, modelo, proveedorChip, tipoChip, descripcionChip);
        System.out.println("--------------------------------------------");
        System.out.println("Datos del Movil ");
        System.out.println(cc.mostrarDatosMovil());
        System.out.println("--------------------------------------------");
        System.out.println("Datos del Movil despues de eliminar");
        cc.eliminarMovil();// Eliminando el objeto
        try {
            System.out.println(cc.mostrarDatosMovil());
        } catch (NullPointerException npe) {
            System.out.println(" El objeto solicitado es nulo");
        }
        System.out.println("Datos del chip después de eliminar");
        System.out.println(cc.mostrarDatosChip());
        sc.close();
    }
}
