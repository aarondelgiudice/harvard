import java.util.*;

class DemoInterface
{
  public static void main (String args [])
  {
      Movie3 thePost = new Movie3 ("The Post", 9, 10, 10);
      Movie3 shapeOfWater = new Movie3 ("The Shape of Water", 9, 10, 9);
      Movie3 ladyBird = new Movie3 ("Lady Bird", 10, 8, 9);

      if (thePost.compareTo (ladyBird) >0 )
	          System.out.println("The Post wins!");
      else if (thePost.compareTo (ladyBird) == 0)
	          System.out.println("The Post and Lady Bird are equally good/bad!");
      else System.out.println("Lady Bird!");

      Movie3 [] m = {thePost, shapeOfWater, ladyBird};
      Arrays.sort (m);
      for (Movie3 a : m) System.out.println (a);
  }
}
