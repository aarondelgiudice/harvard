class ShapeDemo
{
   public static void main (String [] args)
   {
      Shape [] myShapes = {
                               new Circle (12),
                               new Rectangle (3, 8),
                               new Triangle (3, 4, 5)
                          };
      for (Shape s : myShapes)
      {
          System.out.println ("Area = " + s.getArea() +
                              "\t Perimeter = " + s.getPerimeter() );
      }
   }
}