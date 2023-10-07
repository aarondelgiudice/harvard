// IO.java
// Copies a file
// The input file is first on the command line
// The output file is second on the command line

import java.io.*;

public class IO
{
  public static void main (String args[]) throws IOException
  {
      if (args.length != 2) 
      {
          System.out.println ("You must supply precisely 2 arguments!");
          System.exit (0);
      }
      FileInputStream s = new FileInputStream (args[0]);
      InputStreamReader r = new InputStreamReader (s);
      BufferedReader keyboard = new BufferedReader (r);

      FileOutputStream os = new FileOutputStream (args[1]);
      PrintWriter pw = new PrintWriter (os);
      String line = keyboard.readLine ();
      while (line != null)
      {
          System.out.println (line );
          pw.println (line);
          line = keyboard.readLine ();
      }
      pw.close();
      s.close();
   }
}
