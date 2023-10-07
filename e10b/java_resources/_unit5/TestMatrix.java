class TestMatrix
{
   public static void main (String [] args)
   {
      Matrix m = new Matrix (5, true);
      m.writeMatrix();

      Matrix p = new Matrix (3, false);
      p.writeMatrix();

      Matrix foo = m.minor ( 2, 3);
      foo.writeMatrix();


      System.out.println ( p.determinant() );
   }
}
