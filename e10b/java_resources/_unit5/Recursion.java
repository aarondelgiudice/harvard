class Recursion
{
    public static void main (String [] args)
    {
        System.out.println ("Fact(3) = " + fact(3));
        System.out.println ("Fact(9) = " + fact(9));
        //System.out.println ("Fact(-3) = " + fact(-3));
        System.out.println ("power (3.0, 4) = " + power(3.0, 4) );
        System.out.println ("power (3.0, -4) = " + power(3.0, -4) );
    }

    static double power (double x, int n)
    {   // this method computes x raised to the nth power
        // first, the base case
        if (n == 0) return 1.0;
        // now, the recursive case[s]
        else if (n > 0) return x * power (x, n-1);
        else return  1.0 /  power (x, -n);
    }

    static int fact (int n)
    {
       //if (n<0) {  // error }
       if (n == 0) return 1;
       else return n * fact (n-1);
    }
}