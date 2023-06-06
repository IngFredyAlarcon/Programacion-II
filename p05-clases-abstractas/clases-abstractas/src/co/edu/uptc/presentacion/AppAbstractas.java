package co.edu.uptc.presentacion;

import java.util.Scanner;

import co.edu.uptc.control.ControlFiguraGeometrica;
import co.edu.uptc.modelo.Cuadrado;
import co.edu.uptc.modelo.FiguraGeometrica;

public class AppAbstractas {
    private static ControlFiguraGeometrica cf;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        cf = new ControlFiguraGeometrica();
        int lado = 0;
        int radio = 0;
        System.out.println("Ejercicio Clases abstractas");
        int op = 0;
        while (op != 3) {
            System.out.println("1. Calcular el área del Cuadrado");
            System.out.println("2. Calcular el área del Circulo");
            System.out.println("3. Salir");
            System.out.println("Digite su opción: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("digite el valor del lado del cuadrado");
                    lado = sc.nextInt();
                    cf.calcularAreaCuadrado(lado);
                    System.out.println("El área del cudrado es: " + cf.mostrarAreaCuadrado());
                    break;
                case 2:
                    System.out.println("Digite el radio del círculo");
                    radio = sc.nextInt();
                    cf.calcularAreaCirculo(radio);
                    System.out.println("El área del circulo es: " + cf.mostrarAreaCirculo());
                    break;
                case 3:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }

    }
}
