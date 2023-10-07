import java.util.Arrays;

class ByRef
{
    public static void main (String [] args)
    {   
         int[] iq = {3, 5, 7};
         increase (iq, 3);
         System.out.println ( Arrays.toString(iq) );
    }
               
    public static void increase (int [] a, int f)
    {
          for (int i = 0; i < a.length; i++)  
            {  a[i] *= f;    }
    }
                            
}
