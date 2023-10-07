import java.util.Scanner;

class Palindrome
{
    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner (System.in);
        System.out.print ("Please type a string, and I will determine palindrome-hood: ");
        String s = keyboard.nextLine();
        s = s.toUpperCase();

        int left = 0;
        int right = s.length()-1;

        while (left < right)
        {
            if (s.charAt (left) != s.charAt (right))
            {
               System.out.println ("Sorry, this is NOT a palindrome!");
               return;
            }
            left++;
            right--;
        }
        System.out.println ("YES, we have a palindrome!");
    }
}