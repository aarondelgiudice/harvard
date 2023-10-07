// Illustration of how to catch multiple exceptions

import java.util.*;
import java.io.*;

class Exc
{
    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner (System.in);
        try
        {
           System.out.print ("Type the name of a file: ");
           String filename = keyboard.nextLine();
           Scanner in = new Scanner (new File (filename));
           String input = in.next();
           int value = Integer.parseInt (input);
        }
        catch (FileNotFoundException e)
        {
           System.out.println ("Cretin -- No such file exists!");
           return;
        }

        catch (NoSuchElementException e)
        {
           System.out.println ("Knucklehead -- the file is empty!");
           e.printStackTrace();
        }

        catch (NumberFormatException e)
        {
            System.out.println ("Loser -- the file doesn't have an integer!");
            return;
        }
        finally
        {
            System.out.println ("Am in the finally clause!");
        }

        System.out.println ("Am right after the try-catch-finally statement!");
   }
}
