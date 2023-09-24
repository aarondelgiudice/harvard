import java.util.Arrays;

public class LowestGrade {
    public static void main(String[] args) {
        int[][] testCases = new int[][] {
                // define new test cases here
                { 23, 90, 47, 55, 88 },
                { 85 },
                {},
                { 59, 92, 93, 47, 88, 47 },
                { 1, 1, 1 },
                { -100, -99, -52, 0, 75 }
        };

        for (int[] testCase : testCases) {
            System.out.println("removeLowest(" + arrayPrint(testCase) + ") == " + arrayPrint(removeLowest(testCase)));
        }
    }

    public static String arrayPrint(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
            if (i < arr.length - 1) {
                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }

    public static int[] removeLowest(int... grades) {
        // edge case: grades is empty or has only one element
        if (grades == null || grades.length <= 1) {
            return grades;
        }

        // otherwise find the lowest grade and pop it
        else {
            // find the lowest grade
            int lowestGrade = grades[0];

            for (int i = 1; i < grades.length; i++) {
                if (grades[i] < lowestGrade) {
                    lowestGrade = grades[i];
                }
            }

            // create new array without lowest grade
            int[] gradesOutput = new int[grades.length - 1];
            boolean lowestGradeRemoved = false; // pop only one occurance of lowest grade
            int j = 0; // trade index pos in new array
            for (int grade : grades) {
                if (!lowestGradeRemoved) {
                    if (grade != lowestGrade) {
                        gradesOutput[j] = grade;
                        j += 1;
                    } else { // (grade == lowestGrade && lowestGradeRemoved == false) -> skip
                        lowestGradeRemoved = true;
                    }
                } else { // (lowestGradeRemoved == true) -> add any remaining grades
                    gradesOutput[j] = grade;
                    j += 1;
                }
            }
            return gradesOutput;
        }
    }
}