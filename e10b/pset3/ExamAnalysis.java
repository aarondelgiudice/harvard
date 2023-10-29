import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ExamAnalysis {
    static boolean dev = true; // set to true to enable debug messages
    static int nAnswers;

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("I hope you are ready to begin ...\n");

        String answers = getAnswers();
        nAnswers = answers.length();

        File examsFile = getExamsFile();

        ArrayList<String> responses = getStudentReponses(examsFile);

        // analyze student responses
        int[][] analysis = studentAnalysis(responses, answers);

        displayAnalysis(analysis);

        // System.out.println("QUESTION ANALYSIS (* marks the correct response)");
        // System.out.println("~~~~~~~~~~~~~~~~~");

        // String[] choices = { "A", "B", "C", "D", "E", "Blank" };
        // HashMap<String, Integer> map = new HashMap<>();

        // for (int i = 0; i < nAnswers; i++) {
        // System.out.println("Question #" + (i + 1) + ":");

        // for (String choice : choices) {
        // if (String.valueOf(answers.charAt(i)).equals(choice)) {
        // System.out.printf("%10s", choice + "*");
        // } else {
        // System.out.printf("%10s", choice);
        // }
        // map.put(choice, 0);
        // }
        // System.out.println();

        // for (int[] student : analysis) {
        // System.out.println(student.toString());
        // // questionAnalysis[response] += 1;
        // }

        // for (String choice : choices) {
        // System.out.printf("%10d", map.get(choice));
        // }
        // System.out.println();

        // }
    }

    private static String getAnswers() {
        // get answers from user input
        // method will loop until user enters a non-empty string

        // dev, delete
        if (dev) {
            return "ABCEDBACED"; // dev, delete
        }

        Scanner keyboard = new Scanner(System.in);

        String answers = "";

        while (true) {
            System.out.print("Please type the correct answers to the exam questions, one right after the other: ");
            answers = keyboard.nextLine();

            if (answers.length() == 0) {
                // confirm that answers is not empty
                System.out.println("Invalid input, exams answers cannot be emtpy. Please try again.");
                continue;
            } else {
                break;
            }
        }

        keyboard.close();

        return answers;
    }

    private static File getExamsFile() {
        // load exams file from user input
        // method will loop until user enters a valid file path

        // dev, delete
        if (dev) {
            return new File("../java_resources/_unit5/Exams.dat");
        }

        Scanner keyboard = new Scanner(System.in);

        File examsFile = new File("");

        while (true) {
            System.out.printf("What is the name of the file containing each student's responses to the %d questions? ",
                    nAnswers);
            String examsPath = keyboard.nextLine();

            examsFile = new File(examsPath);

            if (!examsFile.exists()) {
                // confirm that exams file exits
                System.out.println("File " + examsPath + " does not exist.");
                continue;
            } else {
                break;
            }
        }

        keyboard.close();
        return examsFile;
    }

    private static ArrayList<String> getStudentReponses(File file) throws FileNotFoundException {
        // get student responses from file
        Scanner fileScanner = new Scanner(file);
        int counter = 0;

        ArrayList<String> responses = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            if (line.length() > 0) {
                counter += 1;

                System.out.println("Student #" + counter + "'s responses:\t" + line);

                responses.add(line);
            } else {
                continue;
            }
        }

        System.out.println("We have reached \"end of file!\"\n");
        System.out.println("Thank you for the data on " + counter + " students. Here's the analysis:\n");

        fileScanner.close();

        return responses;
    }

    private static int[][] studentAnalysis(ArrayList<String> responses, String answers) {
        // analyze student responses
        // returns a 2D array with the following structure:
        // student, correct, incorrect, blank == 4
        int[][] analysis = new int[responses.size()][4];

        // loop over students
        for (int i = 0; i < responses.size(); i++) {
            analysis[i][0] += i + 1;
            for (int j = 0; j < nAnswers; j++) {
                if (responses.get(i).charAt(j) == answers.charAt(j)) {
                    // response match -> update correct col
                    analysis[i][1] += 1;
                } else if (String.valueOf(responses.get(i).charAt(j)).equals(" ")) {
                    // blank response -> update blank col
                    analysis[i][3] += 1;
                } else {
                    // incorrect response -> update incorrect col
                    analysis[i][2] += 1;
                }
            }
        }
        return analysis;
    }

    private static void displayAnalysis(int[][] a) {
        // Column headers
        String header1 = "Student #";
        String header2 = "Correct";
        String header3 = "Incorrect";
        String header4 = "Blank";

        // Print the column headers
        System.out.printf("%10s %10s %10s %10s\n", header1, header2, header3, header4);

        System.out.printf("%10s %10s %10s %10s\n", repeat("~", header1.length()), repeat("~", header2.length()),
                repeat("~", header3.length()), repeat("~", header4.length()));

        for (int[] student : a) {
            System.out.printf("%10d %10d %10d %10d\n", student[0], student[1], student[2], student[3]);
        }

        System.out.println();
    }

    private static String repeat(String s, int n) {
        // repeat a string n times
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}