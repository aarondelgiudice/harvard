import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Find {
    public static void main(String[] args) throws FileNotFoundException {
        String word = args[0].toLowerCase();
        String[] files = Arrays.copyOfRange(args, 1, args.length);

        // check if files were specified
        // if not, alert user and exit
        if (files.length == 0) {
            System.out.println("No files specified.");

            return;
        }

        else {
            for (String filepath : files) {
                File file = new File(filepath);

                // check if file exists
                // file exits -> read file line by line
                if (file.exists()) {
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        line = line.trim(); // strip whitespace

                        // check if line contains word
                        // NOTE: use toLowerCase() to make the search case-insensitive
                        if (line.toLowerCase().contains(word)) {
                            System.out.println(filepath + ":\t" + line);
                        }
                    }

                    scanner.close();
                }

                else {
                    // file does not exist -> alert user and continue
                    System.out.println("File does not exist: " + filepath);

                    continue;
                }
            }
        }
    }
}