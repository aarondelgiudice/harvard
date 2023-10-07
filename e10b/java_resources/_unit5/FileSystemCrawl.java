import java.io.File;
import java.util.Scanner;

class FileSystemCrawl
{
   public static void main (String [] args)
   {
       Scanner keyboard = new Scanner (System.in);
       System.out.print ("Type the name of a file or directory where traversal should start: ");
       String name = keyboard.nextLine();

       File f = new File (name);
       if (! f.exists() )
       {
           System.out.println ("Sorry that file or directory does not exist!");
           System.exit (0);
       }
       else recursivelyCrawl (f, 0);
   }

   static void recursivelyCrawl (File f, int level)
   {
       for (int i = 0; i < level; i++) System.out.print ("   ");

       System.out.println (f.getName());

       if (f.isDirectory() && f.canRead())
       {
             for (File subF : f.listFiles() ) recursivelyCrawl (subF, level+1);
       }
       return;
   }
}