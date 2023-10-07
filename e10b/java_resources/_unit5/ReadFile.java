import java.io.*;
import java.util.*;

class ReadFile
{
    public static void main (String [] args) throws FileNotFoundException
    {
        Scanner input = new Scanner (new File (args[0]));
        while (input.hasNext())
        {
           String text = input.next();
           System.out.println (text);
        }
    }
}