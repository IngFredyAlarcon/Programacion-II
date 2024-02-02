import java.util.Scanner;

public class RecursiveDirect {
    static int cont = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int n = sc.nextInt();
        System.out.println("El factorial de " + n + " es " + factorial(n));
    }

    public static int factorial(int n) {
        System.out.println("llamado # " + cont);
        cont++;
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
