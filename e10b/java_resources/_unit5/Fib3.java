import java.util.Scanner;

class Fib3
{
    public static void main (String [] args)
    {
        Scanner s = new Scanner (System.in);
        System.out.print ("Compute which Fibonacci number? ");
        int n = s.nextInt();
        System.out.println ("The " + n + "th Fibonacci number = " + fib (n));
    }

    static int fib (int n)
    {
          // compute the nth Fibonacci number **recursively**
        if (n == 0) return 0;           // first base case
        else if (n == 1) return 1;      // second base case
        else return fib (n-1) + fib (n-2);
    }
}