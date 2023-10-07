import java.util.*;

class ArrayListDemo
{
    public static void main (String [] args)
    {
        ArrayList<Movie2> myMovies = new ArrayList<Movie2> ();

        myMovies.add (new Movie2 ("The Shape of Water"));
        Movie2 thePost = new Movie2 ("The Post");
        myMovies.add (thePost);
        myMovies.add (1, new Movie2 ("50 Shades of ... Java"));

        System.out.println ("Number of movies =  " + myMovies.size());
        for (Movie2 m : myMovies)
          System.out.println (m.getName());

        if  (myMovies.contains (new Movie2 ("the pOST")))
              System.out.println ("YES");
        else  System.out.println ("NNNoo");
     }
}

