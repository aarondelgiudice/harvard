/** StringTest.java
 *  Demonstrates a few String operations, particularly == vs equals()
 *  Note that == generally does NOT do what you might expect!
 *
 *  @author:     Dr. Henry H. Leitner
 *  @author:     Modified by David Habermehl
 *  @version:    Last Modified, October 29, 2020
 */

public class StringTest
{
  public static void main (String [] args)
  {
     String str1 = "aBcD", str2 = "abcd", str3;

     System.out.println();
     System.out.printf ("str1 is \"%s\"\n", str1);
     System.out.printf ("str2 is \"%s\"\n", str2);

     System.out.println();
     System.out.printf ("str1.equals(str2) is %b\n", str1.equals(str2));
     System.out.printf ("str1.equalsIgnoreCase(str2) is %b\n", str1.equalsIgnoreCase(str2));

     System.out.println();
     System.out.printf ("str1.length() is %d\n", str1.length());
     System.out.printf ("str1.charAt(1) is %c\n", str1.charAt(1));

     System.out.println();
     System.out.printf ("str1.compareTo(\"aBcE\") is %d\n", str1.compareTo("aBcE"));
     System.out.printf ("str1.compareTo(\"aBcC\") is %d\n", str1.compareTo("aBcC"));
     System.out.printf ("str1.compareTo(\"aBcD\") is %d\n", str1.compareTo("aBcD"));

     System.out.println();
     System.out.printf ("str1.indexOf('D') is %d\n", str1.indexOf('D'));
     System.out.printf ("str1.indexOf(\"Bc\") is %d\n", str1.indexOf("Bc"));
     System.out.printf ("str1.indexOf(\"zz\") is %d\n", str1.indexOf("zz"));

     System.out.println();
     System.out.printf ("str1.concat(\"efg\") is \"%s\"\n", str1.concat("efg"));
     System.out.printf ("str1 is still \"%s\"! Does that surprise you?\n", str1);

     System.out.println();
     str2 += "abcd";
     System.out.printf ("After str2 += \"abcd\"; then str2 is \"%s\"\n", str2);
     System.out.printf ("str2.lastIndexOf(\"c\") is %d\n", str2.lastIndexOf("c"));

     System.out.println();
     str3 = str1.toLowerCase();
     System.out.printf ("After str3 = str1.toLowerCase(); then str3 is \"%s\"\n", str3);
     str3 = str1.toUpperCase();
     System.out.printf ("After str3 = str1.toUpperCase(); then str3 is \"%s\"\n", str3);

     System.out.println();
     str3 = String.valueOf (123);
     System.out.printf ("After str3 = String.valueOf(123); then str3 is \"%s\"\n", str3);
     System.out.printf ("str3.equals(\"123\") is %b\n", str3.equals("123"));
     System.out.printf ("str3 == \"123\") is %b\n", str3 == "123");

     System.out.println();
  }
}
