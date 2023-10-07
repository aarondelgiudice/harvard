

foobar:
  for (int i = 0; i < intArray.length; i++)
  {
     for (int j = 0; j < intArray[i].length; j++)
     {
        if (intArray[i][j] == item)
        {
           System.out.println ("Found it!");
           break foobar;