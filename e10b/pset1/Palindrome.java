import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        // get user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");

        String userInput = scanner.nextLine();

        // close scanner
        scanner.close();

        // convert input to lowercase
        String lowerCaseInput = userInput.toLowerCase();

        // recursively check if input is a palinrome
        System.out.println("isPalindrome(\"" + userInput + "\") == " + isPalindrome(lowerCaseInput));

        if (false) {
            // test cases
            String[] testCases = new String[] {
                    "madam",
                    "1x1",
                    "\"My gym tasks are too lonely?\" a Jay Leno looter asks at my gym.",
                    "Cigar? Toss it in a can, it is so tragic!",
                    "\"Ed, I saw Harpo Marx ram Oprah W. aside.\"",
                    "12321"
            };

            for (String testCase : testCases) {
                System.out.println("isPalindrome(\"" + testCase + "\") == " + isPalindrome(testCase.toLowerCase()));
            }
        }
    }

    public static boolean isPalindrome(String s) {
        // first base case: if the string is empty or has only one character, it's a
        // palindrome
        if (s == null || s.length() <= 1) {
            return true;
        }

        // find the first valid char at the beginning of string
        int start = 0;
        while (start < s.length() && !Character.isLetterOrDigit(s.charAt(start))) {
            start++;
        }

        // find the first valid char at the end of the string
        int end = s.length() - 1;
        while (end >= 0 && !Character.isLetterOrDigit(s.charAt(end))) {
            end--;
        }

        // second base case: if there are no valid characters -> return true
        if (start >= end) {
            return true;
        }

        // check if input is a palindrome
        else {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            // increment substring index
            return isPalindrome(s.substring(start + 1, end));
        }
    }

}
