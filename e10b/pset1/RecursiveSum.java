import java.util.Scanner;

public class RecursiveSum {
    public static void main(String[] args) {
        // get user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input int: ");

        int n = scanner.nextInt();

        scanner.close();

        // recursively compute sum
        System.out.println("sumTo(" + n + ") == " + sumTo(n));
    }

    public static double sumTo(int n) {
        // edge cases: n is negative or zero
        if (n < 0) {
            throw new IllegalArgumentException("n must be a positive integer. received: " + n);
        } else if (n == 0) {
            return 0.0;
        }

        // otherwise, recursively computer sum
        else if (n == 1.0) {
            return 1.0;
        }

        else {

            return 1.0 / n + sumTo(n - 1);
        }
    }
}