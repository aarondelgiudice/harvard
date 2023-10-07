import java.io.*;

class FileIO
{
    public static void main (String [] args)
    {
        File f = new File ("data.txt");

        if (f.exists() && f.canRead())
        {
            System.out.println ("Length = " + f.length());
        }
        else System.out.println ("Sorry, file does not exist or cannot be read!");
    }
}