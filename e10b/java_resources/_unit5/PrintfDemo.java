class PrintfDemo
{
    public static void main (String [] args)
    {
        System.out.printf ("I have %.2f bugs to fix!\n", 47568.09876);
        System.out.printf ("I have %,.2f bugs to fix!\n", 47568.09876);
        System.out.printf ("I have %,15.3f bugs to fix!\n", 47568.09876);
    }
}
