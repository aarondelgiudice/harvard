import java.util.*;

enum Months {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG,
    SEP, OCT, NOV, DEC
};

class Enumeration {
    public static int daysInMonth(Months m, int year) {

        switch (m) {
            // YOU NEED TO WRITE THIS PART
            // check if month if feb
            case FEB: {
                // check if leap year
                if (year % 4 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            }
            // check if month is 30 vs 31 days
            // My preference was to use a single case statement vs. multiple case statements
            // for each month w/ 30 days, but I was unable to get the code to work in time.
            // Here is the code I was attemping to use: `case m == Months.APR || m ==
            // Months.JUN || m == Months.SEP || m == Months.NOV:`
            case APR: {
                return 30;
            }
            case JUN: {
                return 30;
            }
            case SEP: {
                return 30;
            }
            case NOV: {
                return 30;
            }
            default:
                return 31;
        }
    }

    public static void main(String[] args) {
        for (Months m : Months.values()) {
            System.out.println(m + " 2023 has " +
                    daysInMonth(m, 2023) + " days!");
        }
    }
}