class StringEfficiency
{
   public static void main (String [] args)
   {
       String result = "";
       for (int i = 0; i < 500000; i++)
       {
           result += "some more stuff";
       }
   }
}