import java.util.Scanner;
import java.util.Stack;

/**
   This program uses a stack to check whether an expression has balanced
   parentheses.
*/
public class ParenChecker
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
      System.out.print ("Enter an expression containing { [ ( ) ] }: ");
      String expression = in.nextLine();

      Stack<Character> parens = new Stack<Character>();

      for (int i = 0; i < expression.length(); i++)
      {
         char ch = expression.charAt(i);
         if (ch == '(' || ch == '[' || ch == '{')
         {
             parens.push (ch);
         }
         else if (ch == ')' || ch == ']' || ch == '}')
         {
            if (parens.size() == 0)
            {
               System.out.println ("NOT a balanced expression!");
               return;
            }
            char open = parens.pop();
            if (  ???  )
                   {
                      System.out.println ("NOT a balanced expression!");
                      return;
                   }
            }
         }
         if ( ??? ) System.out.println ("YES, your expression was balanced!");
         else System.out.println ("No, it was NOT a balanced expression!");
   }
}


