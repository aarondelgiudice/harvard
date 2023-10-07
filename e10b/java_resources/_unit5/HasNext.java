import java.util.Scanner;

class HasNext
{
    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner (System.in);

        int sum = 0;
        int count = 0;

        System.out.print ("Please type an integer: ");

        while (keyboard.hasNextInt())
        {
            sum += keyboard.nextInt();
            count++;
            System.out.print ("Please type an integer: ");
        }
        System.out.println ("All Done!");
        System.out.println ("The sum of " + count + " integers = " + sum);
    }
}