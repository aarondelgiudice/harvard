class IndefiniteArgs
{
    public static void main (String [] args)
    {
        System.out.println ( max (4, 17 -3, 22, 11));   // outputs 22
        System.out.println ( max (44) );                // outputs 44
        System.out.println ( max () );                  // outputs ????
    }

    static int max (int ... values)
    {
         if (values.length == 0)
         {
             System.out.println ("Sorry, you need more than 0 values!");
             System.exit(0);
         }
         int largest = values [0];
         for (int i = 1; i < values.length; i++)
         {
             if (values[i] > largest) largest = values[i];
         }
         return largest;
    }
}