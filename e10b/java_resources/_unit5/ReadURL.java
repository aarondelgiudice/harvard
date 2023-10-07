import java.io.*;
import java.util.*;
import java.net.*;

class ReadURL
{
    public static void main (String [] args) throws FileNotFoundException, IOException
    {
        URL u = new URL ( args[0] );
        Scanner url = new Scanner (u.openStream());

        while (url.hasNextLine())
        {
           String text = url.nextLine();
           System.out.println (text);
        }
    }
}