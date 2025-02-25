package co.edu.uptc.app;

import java.util.Scanner;

public class Cadena {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String cadena = sc.next();
        System.out.println(cadena);
        System.out.println(cadena.indexOf("@"));
        String subcadena = cadena.substring(0,cadena.indexOf("@"));
        String subcadena2 = cadena.substring(cadena.indexOf("@")+1);
        System.out.println(subcadena);
        System.out.println(subcadena2);

        String[] subcadena3 = cadena.split("@");
        for (String string : subcadena3) {
            System.out.println(string);
        }
        
    }
}
