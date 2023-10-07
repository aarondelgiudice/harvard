// Simple file processing example
//  contains a subtle bug
import java.io.*;
import java.util.*;

class SubtleError
{
    public static void main (String [] args) throws IOException
    {
        Scanner input = new Scanner (new File (args[0]));
        expand (input);
        System.out.println ("\nALL DONE!\n");
    }

    public static void expand (Scanner input)
    {
        while (input.hasNextLine())
        {
            String text = input.nextLine();
            if (text.length() > 0 && text.charAt(0) == '.')
            {
                System.out.println (text.substring (1));
                for (int i = 1; i < text.length(); i++)
                {
                    System.out.print ("-");
                }
                System.out.println ();
            }
            else System.out.println (text);
        }
    }
}
