import java.util.Scanner;

public class TestRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Recursive r = new Recursive();
        int n = 0, sum = 0, factorial = 1;
        System.out.println("enter a number");
        n = sc.nextInt();
        sum = r.sumToN(n);
        System.out.println("sumattion: " + sum);
        factorial = r.factorial(n);
        System.out.println("factorial: " + factorial);
    }

}
