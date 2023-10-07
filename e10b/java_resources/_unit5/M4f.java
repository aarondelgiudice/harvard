import java.io.*;
import java.util.*;

class M4f
{
    public static void main (String [] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        Scanner input = null;
        String fileName = args[0];
        while (input == null)
        {
           try{
                input = new Scanner (new File ( fileName ));
             }
           catch (IOException e)
           { 
              System.out.println("Sorry, file " + fileName + " is a bad file"); 
              System.out.print ("Type a new file name: ");
              fileName = keyboard.nextLine();
           }
        }
 
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

