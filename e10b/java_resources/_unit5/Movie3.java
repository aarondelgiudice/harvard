//  Movie3.java
/** Illustration of simple inheritance
  * based on example in "On to Java", by P. H. Winston
  * @author  Henry H. Leitner
  * @version Last modified on November 23, 2018
  */
import java.io.*;

public class Movie3  extends Attraction implements Comparable<Movie3>, Serializable

{
    // First, define instance variables:
    protected int
           script = 5,
           acting = 5,
        directing = 5;

    Movie3 ( )
    {
       System.out.println ("Inside zero-parameter Movie constructor!");
    }

    Movie3 (String movieName)
    {
       System.out.println ("Inside one-parameter Movie constructor!");
       name = movieName;
    }

    Movie3 (String movieName, int s, int a, int d, int m)
    {
        System.out.println ("Inside 5-parameter Movie constructor!");
        name      = movieName;
        script    = s;
        acting    = a;
        directing = d;
        timeInMinutes   = m;
    }

    Movie3 (String name, int s, int a, int d)
    {
      System.out.println ("Inside 4-parameter Movie constructor!");
      script = s;
      acting = a;
      directing = d;
      this.name = name;
    }

   // Define an overloaded public method named rating:
   public int rating (double scaleFactor)
   {
       return (int) (scaleFactor *
                     (script + acting + directing));
   }

   public int rating()
   {
     return script + acting + directing;
   }

   public boolean equals (Object o)
   {
       if (o instanceof Movie3)
       {
           Movie3 other = (Movie3) o;
           return other.getName().equalsIgnoreCase (this.getName());
       }
       else return false;
   }

   public int compareTo  (Movie3 otherMovie)
   {
        if  (this.rating() < otherMovie.rating())  return -1;
        else if (this.rating() > otherMovie.rating() ) return 1;
        else return 0;
   }

   public String toString()
   {
        return   "Movie:  "   +  this.name;
   }
}

