import java.util.*;

class Remove
{
    public static void main (String [] args)
    {
        String [] data1 = {"a", "b", "c", "a", "b", "c", "a", "b", "c"};
        test (data1, "a");  //return ["b", "c", "b", "c","b", "c"]
        test (data1, "b");
        test (data1, "c");

        String [] data2 = {"a", "a", "a", "a", "a"};
        test (data2, "b");   // return [a, a, a, a, a]]
        test (data2, "a");    // incorrect result

        String [] data3 = {};
        test (data3, "a");
    }

    public static void test (String [] data, String target)
    {
      ArrayList<String> list = new ArrayList<String>();
      for (String word : data) list.add(word);
      System.out.println ("Testing " + list);
      System.out.println ("   removing " + target);
      removeAll (list, target);
      System.out.println ("   result = " + list);
      System.out.println ();
    }

   public static void removeAll (ArrayList<String> list, String target)
   {  // contains a subtle error
      for (int i =  list.size()-1; i >= 0; i--)
      {
         if (list.get(i).equals(target))
         {
             list.remove(i);
         }
      }
   }
}
