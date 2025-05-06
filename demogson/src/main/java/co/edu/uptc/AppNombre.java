package co.edu.uptc;

public class AppNombre {
    public static void main(String[] args) {
        String n = "Juan";
        String a = "Perez";
        System.out.println(nombreCompleto(n, a));
    }

    public static String nombreCompleto(String n, String a){
        return n + " " + a;
    }
}
