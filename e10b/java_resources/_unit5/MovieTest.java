class MovieTest
{
    public static void main (String [] args)
    {
        Movie thePost = new Movie (9, 8, 10);
        System.out.println ("My rating for The Post movie = " + thePost.rating() );

        Symphony beethoven9th = new Symphony (9, 10, 7);
        System.out.println ("My rating for Beethoven's Ninth Symphony = " + beethoven9th.rating(1.2) );
    }
}