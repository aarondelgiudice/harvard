import java.io.*;

class FileIO2
{
    public static void main (String [] foobar)
    {
        if (foobar.length != 1)
        {
            System.out.println ("Sorry, you need to supply precisely one file name ...");
            System.exit(0);
        }
        File f = new File ( foobar[0] );

        if (f.exists() && f.canRead())
        {
            System.out.println ("Length = " + f.length());
            System.out.println (f.getAbsolutePath());
        }
        else System.out.println ("Sorry, file does not exist or cannot be read!");
    }
}