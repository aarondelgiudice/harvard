import java.util.*;

class ForEachExample
{
    enum DaysOfWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY}

    public static void main (String [] args)
    {   // input and add up # of hours worked in one week
        DaysOfWeek [] d = DaysOfWeek.values();
        Scanner keyboard = new Scanner (System.in);
        double sum = 0.0;

        for (DaysOfWeek oneDay : d)
        {
            System.out.print ("How many hours did you work on " + oneDay + "? ");
            sum += keyboard.nextDouble();
        }
        System.out.println ("You worked a total of " + sum + " hours!");
    }
}