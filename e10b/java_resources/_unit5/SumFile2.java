/*  File SumFile.java
 *  Reads a text file of integers, prints the sum of the ints found.
 *  @author  Dr. Henry H. Leitner
 *  @version Last Modified:  November 19, 2018
*/

import java.io.*;
import java.util.*;

class SumFile2
{
   public static void main (String [] args)
   {
      int      count = 0;      // the # of numbers input
      int      sum = 0;        // the sum of the numbers

      Scanner keyboard = new Scanner (System.in);
      Scanner in = null;

      while (in == null)
      {
          System.out.print ("Type the name of an input file containing integers: ");
          String fname = keyboard.nextLine();

          try
          {
             in = new Scanner (new File (fname));
          }
          catch (FileNotFoundException e)
          {
               System.out.print ("Trouble opening or reading the file");
               System.out.println(" ... maybe it was misspelled???  TRY AGAIN!");
          }
      }
      // variable in is now connected to an existing file


          while (in.hasNextInt() )
          {
             int x = in.nextInt();
             count++;
             System.out.println ("Value #" + count + " is " + x);
             sum += x;
          }
          System.out.println("Sum of " + count + " numbers is " + sum);
	      in.close();
       }

   }
