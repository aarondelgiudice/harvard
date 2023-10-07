import java.util.*;
// this class could be used in applying Cramer's Rule to solve
// systems of simultaneous equations

class Matrix
{
   private int [] [] theValues;
   private int size;
   
   public int getValue (int row, int col)
   {
      return theValues[row-1][col-1];
   }

   public void setValue (int row, int col, int value)
   {
      theValues [row-1][col-1] = value;
   }

   public int getSize()
   {
      return theValues.length;
   }

   public Matrix (int dimension, boolean random)
   {
      size = dimension;
      Scanner keyboard = new Scanner (System.in);
      theValues = new int [dimension] [dimension];
      for (int i = 0; i < dimension; i++)
      {
          for (int j = 0; j < dimension; j++)
          {
              if (random) theValues[i][j] = (int)(Math.random()*100)+1;
              else
              {
                 System.out.print("Row " + i + ", Col " + j + " = ");
                 theValues[i][j] = keyboard.nextInt();
              }
          }
      }
   }
 
   public Matrix minor (int r, int c)
   {
       Matrix b = new Matrix (size-1, true);
       int i, j, ii, jj;
       for (i = 1; i <= this.getSize()-1; i++)
       {
          if (i < c) ii = i;
          else ii = i + 1;
          for (j = 1; j <= this.getSize()-1; j++)
          {
            if (j < r) jj = j;
            else jj = j+1;
            b.setValue(j, i, getValue(jj, ii));
          }
        }
        return b;
    }

   public int determinant ()
   {
        int sum = 0;
        int n = getSize();
        Matrix b = new Matrix (n-1, true);
        if (n ==1) return getValue(1,1);
        else
        {
           for (int i = 1; i <= n; i++)
           {
                 b = minor(i, 1);
                 b.writeMatrix();
                 if ( i%2 == 1) sum += b.determinant() * getValue(i, 1);
                 else sum -= b.determinant() * getValue (i, 1);
            }
            System.out.println ("N = " + n + ", and determinant = " + sum);
            return sum;
         }
     }
       

   public void writeMatrix()
   {
      for (int i = 0; i < size; i++)
      {
          for (int j = 0; j < size; j++)
          {
             System.out.printf("%4d", theValues[i][j]);
          }
          System.out.println();
      }
      System.out.println("\n\n");
    }
}
