public class RecursiveIndirect {
    public static void main(String[] args) {
        int n = -5;
        System.out.println("El valor absoluto de " + n + " es: " + valorAbsoluto(n));
    }

    public static int valorAbsoluto(int n) {
        if (n < 0) {
            return negativo(n);
        } else {
            return n;
        }
    }

    public static int negativo(int n) {
        return valorAbsoluto(-n);
    }
}
