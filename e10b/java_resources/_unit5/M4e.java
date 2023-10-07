import java.io.*;
import java.util.*;

class M4e
{
    public static void main (String [] args) 
    {
        Scanner input;
        try{
             input = new Scanner (new File ( args[0] ));
        }
        catch (IOException e)
        { System.out.println("Sorry, file " + args[0] + " is a bad file"); return; }
 
        double current = input.nextDouble();
        while (input.hasNextDouble())
        {
            double next = input.nextDouble();
            System.out.println ( current + " to " + next +
                                 ", change = " + (next-current));
            current = next;
        }
    }
}

