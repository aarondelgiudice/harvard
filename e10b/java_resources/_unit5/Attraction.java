// Attraction.java
/** Based upon an idea in Winston's "On to Java" text
  * This class gets extended by Movie2 and Symphony2
  * @author Henry Leitner
  * @version Last modified on November 14, 2018
  */
import java.io.*;

public abstract class Attraction implements Serializable
{
   protected String name;
   protected int timeInMinutes;

   public Attraction ()
   {
       timeInMinutes = 75;
       System.out.println ("I am in the Attraction constructor!");
   }

   abstract int rating();

   public int getMinutes ()            { return timeInMinutes; }
   public double getHours()            { return timeInMinutes / 60.0 ; }
   public void setMinutes (int d)      { timeInMinutes = d;    }
   public void setHours (double hours) { timeInMinutes = (int) (hours * 60); }
   public String getName ()            { return name;    }

}
