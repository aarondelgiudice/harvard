import java.util.Scanner;

class PalindromeImproved
{
    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner (System.in);
        System.out.print ("Please type a string, and I will determine palindrome-hood: ");
        String s = keyboard.nextLine();
        s = s.toLowerCase();

        int left = 0;
        int right = s.length()-1;

        while (left < right)
        {
            char lc = s.charAt (left);
            char rc = s.charAt (right);

            if (lc < 'a' || lc > 'z')
            {
                left++;
                continue;
            }
            // you know that lc contains an alphabetic character
            if (! (rc >= 'a' && rc <= 'z') )
            {
                right--;
                continue;
            }
            // I know both lc and rc contain an alphabetic character

            if (lc != rc)
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