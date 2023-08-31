public class Recursive {

    public static int i = 1;

    // sumatoria de n hasta 1
    public int sumToN(int n) {
        System.out.println("call method " + i);
        if (n <= 1) {
            i++;
            return 1;
        } else {
            i++;
            return n + sumToN(n - 1);
        }
    }

    // factorial de un número
    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
