public class App {
    public static void main(String[] args) {
        int numero = 5;
        System.out.println("El factorial de " + numero + " es: " + factorial(numero));
    }

    public static int factorial(int n) {
        // Caso base
        if (n == 0) {
            return 1;
        }
        // Caso recursivo
        else {
            return n * factorial(n - 1);
        }
    }
}
