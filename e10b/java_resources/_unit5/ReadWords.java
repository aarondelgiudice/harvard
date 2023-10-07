import java.util.Scanner;

class ReadWords
{
    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner (System.in);
        keyboard.useDelimiter ("");
        while (keyboard.hasNext())
        {
            System.out.println (keyboard.next());
        }
    }
}