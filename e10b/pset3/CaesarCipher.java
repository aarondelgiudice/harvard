import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CaesarCipher {
    static boolean dev = false; // set to true to enable debug messages

    // encode string
    public static String caesarEncipher(String input, int shift) {
        StringBuilder encoded = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char shifted = (char) ((c - 'A' + shift) % 26 + 'A'); // alphabet is 26 chars
                encoded.append(shifted);
            } else {
                encoded.append(c);
            }
        }

        // echo the encoded message in the terminal
        if (dev) {
            System.out.println(encoded.toString());
        }

        return encoded.toString();
    }

    // decode string
    public static String caesarDecipher(String input, int shift) {
        return caesarEncipher(input, 26 - shift); // reverse shift to decode
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to CaesarCipher\n");

        while (true) {
            int user = 0;
            int shift = 0;
            String inputFileName = null;
            String outputFileName = null;

            while (true) {
                try {
                    System.out.print("Enter 1 to encipher, or 2 to decipher (-1 to exit): ");
                    user = scanner.nextInt();
                    scanner.nextLine(); // consume next line

                    if (user == -1 || user == 1 || user == 2) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 1 to encipher, or 2 to decipher (-1 to exit).");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine(); // will loop indefinitely without this
                    continue;
                }
            }

            if (user == -1) {
                break; // exit program
            }

            while (true) {
                try {
                    System.out.print("What shift should I use? ");
                    shift = scanner.nextInt();
                    scanner.nextLine(); // consume next line
                    if (shift > 0 || shift < 0) {
                        break;
                    } else {
                        System.out.println("Invalid input. Shift must not equal 0.");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please try again.");
                    scanner.nextLine(); // will loop indefinitely without this
                    continue;
                }
            }

            System.out.print("What is the input file name? ");
            inputFileName = scanner.nextLine();
            System.out.print("What is the output file name? ");
            outputFileName = scanner.nextLine();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

                String line = new String();

                while ((line = reader.readLine()) != null) {
                    if (user == 1) {
                        writer.write(caesarEncipher(line, shift));
                    } else if (user == 2) {
                        writer.write(caesarDecipher(line, shift));
                    }
                    writer.newLine();
                }

                reader.close();
                writer.close();

                System.out.println("DONE!");
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.\n");
                continue;
            } catch (IOException e) {
                System.out.println("Error reading file. Please try again.\n");
                continue;
            }
        }
        scanner.close();
    }
}
