import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        // get user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first word or phrase: ");

        String userInput1 = scanner.nextLine();

        System.out.print("Enter second word or phrase: ");

        String userInput2 = scanner.nextLine();

        scanner.close();

        // convert to lowercase and remove whitespace
        String cleanedUserInput1 = userInput1.toLowerCase().replaceAll("\\s*", "");

        String cleanedUserInput2 = userInput2.toLowerCase().replaceAll("\\s*", "");

        // check if strings are anagrams
        boolean isAnagram = isAnagram(cleanedUserInput1, cleanedUserInput2);

        System.out.println("isAnagram(\"" + userInput1 + "\", \"" + userInput2 + "\") == " + isAnagram);

    }

    public static boolean isAnagram(String s1, String s2) {
        // edge cases
        if (s1 == null || s2 == null) {
            return false; // s1 or s2 is null
        }

        else if (s1 == null && s2 == null) {
            return true; // null is an anagram of null
        }

        if (s1.length() == 0 || s2.length() == 0) {
            return false; // s1 or s2 is empty
        }

        else if (s1.length() == 0 && s2.length() == 0) {
            return true; // empty string is an anagram of empty string
        }

        // s1, s2 are non-null, not empty strings -> test if they are anagrams

        // convert strings to char arrays (for sorting purposes)
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        // sorted anagrams will be equal (ex non-alphanmeric chars)
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        // loop over both strings and compare each alphanmeric char
        int i = 0;
        int j = 0;

        while (i < s1Chars.length && j < s2Chars.length) {
            // scan s1Chars, s2Chars until an alphanmeric char is found
            while (i < s1Chars.length && !Character.isLetterOrDigit(s1Chars[i])) {
                i++;
            }

            while (j < s2Chars.length && !Character.isLetterOrDigit(s2Chars[j])) {
                j++;
            }

            // if s1Chars[i] != s2Chars[j] -> not an anagram
            if (s1Chars[i] != s2Chars[j]) {
                return false;
            }

            i++;
            j++;
        }

        // all chars are equal -> is an anagram
        return true;
    }
}