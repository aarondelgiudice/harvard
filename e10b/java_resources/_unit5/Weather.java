// Output the change in temperature between each pair of double values contained in a file

import java.io.*;
import java.util.Scanner;

class Weather
{
    public static void main (String [] args) throws FileNotFoundException
    {
         Scanner input = new Scanner (new File (args[0]) );

         double previous = input.nextDouble();
         while (input.hasNextDouble())
         {
             double next = input.nextDouble();
             System.out.println (previous + " to " + next +
                                   ", change = " + (next-previous));
             previous = next;
         }
         System.out.println ("ALL DONE!");
         input.close();
    }
}