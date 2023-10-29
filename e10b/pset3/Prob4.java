import java.util.InputMismatchException;
import java.util.Scanner;

public class Prob4 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int n1, n2;

        boolean success = false;

        while (!success) {
            try {
                System.out.print("Type an int: ");
                n1 = keyboard.nextInt();
                System.out.print("Now type another int: ");
                n2 = keyboard.nextInt();
                int r = n1 / n2;
                success = true;
            } catch (ArithmeticException e) {
                e.printStackTrace(); // this may be overkill
                System.out.println("Divide by zero error");
                keyboard.nextLine(); // will loop indefinitely without this
            } catch (InputMismatchException e) {
                e.printStackTrace(); // this may be overkill
                System.out.println("Invalid user input, expected integer values");
                keyboard.nextLine(); // will loop indefinitely without this
            }
        }
    }
}