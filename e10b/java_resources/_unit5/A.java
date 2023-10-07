import java.util.ArrayList;

class A
{
    public static void main (String [] args)
    {
        ArrayList<Number> list = new ArrayList<Number>();
        list.add (1);         // list.add (new Integer (1))
        list.add (3.1415);    // automatic "boxing"
        System.out.println (list.get(1));   // automatic "unboxing"
    }
}