// Symphony.java
/** Based upon an idea in: "On to Java", by Patrick Winston
  * @author Henry H. Leitner
  * @version Last modified on October 20, 2018
  */

class Symphony
{
   // 3 instance variable declarations follow
   private int music, playing, conducting;

   // 3 class variable (constant) declarations follow
   private static int numberOfSymphonies = 0;

   public Symphony (int m, int p, int c)
   {
       music = m;
       playing = p;
       conducting = c;
       numberOfSymphonies++;
   }

   public static int getNumberOfSymphonies ()
   {
      return numberOfSymphonies;
   }

   // 1 instance method follows
   public double rating (double scale)
   {
       return (music + playing + conducting) * scale;
   }

   public int rating ()
   {
       return (music + playing + conducting) ;
   }


   // 1 class method follows
   public static void help()
   {
      System.out.println ("Symphonies are cool!");
   }
}

