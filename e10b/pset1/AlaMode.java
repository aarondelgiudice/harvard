import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AlaMode {
    public static void main(String[] args) {
        // get user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input integers, separated by commas: ");

        // convert input string to array of ints
        String userInput = scanner.nextLine();

        // close scanner
        scanner.close();

        String[] strInput = userInput.split(",\\s*"); // split along commas and variable whitespace
        int[] intInput = new int[strInput.length];
        for (int i = 0; i < strInput.length; i++) {
            intInput[i] = Integer.parseInt(strInput[i]);
        }

        // remove lowest grade
        int mode = mode(intInput);

        System.out.println("mode(" + Arrays.toString(strInput) + ") == " + mode);
    }

    public static int mode(int[] arr) {
        // edge case: arr has only one element
        if (arr.length <= 1) {
            return arr[0];
        }

        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (counter.containsKey(arr[i])) {
                counter.put(arr[i], counter.get(arr[i]) + 1);
            } else {
                counter.put(arr[i], 1);
            }
        }

        int max = 0;
        int mode = 0;

        for (int key : counter.keySet()) {
            if (counter.get(key) > max) {
                max = counter.get(key);
                mode = key;
            }
        }

        return mode;
    }
}