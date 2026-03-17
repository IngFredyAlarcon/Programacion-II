package co.edu.uptc.presentacion;

import java.util.Random;

public class Pruebas {
    public static void main(String[] args) {
        String codigoAleatorio = "";
        int x = 0;
        Random rdn = new Random();
        int min = 1000000; // valor mínimo de 7 dígitos
        int max = 9999999; // valor máximo de 7 dígitos
        for (int i = 1; i <= 10; i++) {
            x = rdn.nextInt(max - min);
            codigoAleatorio = "abc" + (rdn.nextInt(max - min + 1) + min);
            System.out.println(x);
        }
        System.out.println(codigoAleatorio);
    }
}
