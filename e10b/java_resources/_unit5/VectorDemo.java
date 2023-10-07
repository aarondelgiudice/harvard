/*
 *  File: VectorDemo.java
 *  Description:  This program illustrates the use of the
 *    java.util.Vector class. Unlike a Java array, which
 *    is static in size during the execution of a program,
 *    a Vector is dynamic in size. It can grow and shrink
 *    during program execution. Vectors are used when it
 *    it is not known in advance how many array elements will
 *    be needed.
 *  @author  Henry Leitner
 *  @version Last modified on February 13, 2021
 */

import java.util.*;

public class VectorDemo
{
    /**
     *  printVector() prints its parameter. Note the use of
     *   v.size to determine the number of elements in the vector.
     *  @param v -- a Vector
     */
    public static void printVector ( Vector<Number> v)
    {
        for (int k = 0; k < v.size(); k += 2)
        {
            System.out.print(v.elementAt(k));
            System.out.println("\t\t" + v.elementAt(k+1));
        }
    }

    /**
     *  main() creates a Vector object and adds elements to it.
     */
    public static void main(String [] args)
    {
        Vector<Number> vector = new Vector<Number>(); // An empty vector

        int bound = (int)(Math.random() * 20);
        System.out.print ("Fill a vector with " + bound + " random ");
        System.out.println ("floating-point and " + bound + " random integers");
        for (int k = 0; k < bound; k++ )              // Insert a random double
        {
            vector.addElement( Math.random()  );
            vector.addElement( (int) ( Math.random() * 10) );
        }
        printVector(vector);                     // Print the elements
        System.out.println();

        // Alternative way to print using the new and FOR LOOP
        for (Number n : vector )
        {
           System.out.println (n);
        }
   }
}	            // of VectorDemo
