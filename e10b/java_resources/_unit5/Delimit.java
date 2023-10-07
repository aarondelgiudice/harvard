// Illustrates the use of a simple "regular expression"

import java.util.Scanner;

class Delimit
{
    public static void main (String [] args)
    {
       Scanner in = new Scanner(System.in);
       String word1, word2;
       in.useDelimiter ("[#?\t]+");
       System.out.println ("Enter two words separated by a # or ? or a tab: ");

       word1 = in.next();
       word2 = in.next();
	   System.out.println ("FIRST you entered: " + word1);
	   System.out.println ("THEN you entered: " + word2);
     }
}


