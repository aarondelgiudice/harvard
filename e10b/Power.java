public class Power {

    public static void main(String[] args) {
        // part i.
        System.out.println("power(x=2.0, n=3) == " + power(2.0, 3));

        System.out.println("power(x=2.0, n=0) == " + power(2.0, 0));

        System.out.println("power(x=2.0, n=-1) == " + power(2.0, -1));

        System.out.println("power(x=1.0, n=1024) == " + power(1.0, 1024));

        // part ii.
        // "How many total calls (including the initial one) on the modified power in
        // part i above will occur when computing power (foobar, 1024) ?"
        // Answer: 11 total calls
        // power(x=foobar, n=1024) -> +1 recurive call
        // power(x=foobar, n=512) -> +1 recurive call
        // power(x=foobar, n=256) -> +1 recurive call
        // power(x=foobar, n=128) -> +1 recurive call
        // power(x=foobar, n=64) -> +1 recurive call
        // power(x=foobar, n=32) -> +1 recurive call
        // power(x=foobar, n=16) -> +1 recurive call
        // power(x=foobar, n=8) -> +1 recurive call
        // power(x=foobar, n=4) -> +1 recurive call
        // power(x=foobar, n=2) -> +1 recurive call
        // power(x=foobar, n=1) -> +1 recurive call
    }

    public static double power(double x, int n) {
        if (n == 0)
            return 1.0;
        // else if (n > 0)
        // return x * power(x, n - 1);
        else if (n > 0)
            if (n % 2 == 0)
                // if n is even, use x*x^(n/2) (new behavior)
                return power(x * x, n / 2);
            else
                // if n is odd, recursively compute x^(n-1) (original behavior)
                return x * power(x, n - 1);
        else
            return 1.0 / power(x, -n);
    }
}