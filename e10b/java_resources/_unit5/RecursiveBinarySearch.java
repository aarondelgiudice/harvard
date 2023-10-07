static int binary (int [] a, int fromIndex, int toIndex, int key)
{  // recursively find the value key in the array a
   if (fromIndex > toIndex) return -1;
   else
   {
       int middle = (fromIndex + toIndex) / 2;
       if (key == a[middle) return middle;
       else if (key > a[middle) ...
   }
}