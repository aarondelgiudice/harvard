/** StringBuilderTest.java
 *  Demonstrates a few StringBuilder methods
 *  Note that unlike String objects, StringBuilder objects are MUTABLE
 *
 *  @author:    Dr. Henry H. Leitner
 *  @version:   Last Modified January 13, 2013
 */

public class StringBuilderTest 
{
  public static void main(String[] args) 
  {
    StringBuilder sbuf1 = new StringBuilder();
    StringBuilder sbuf2 = new StringBuilder("abcd");
    StringBuilder sbuf3 = new StringBuilder(30);
    System.out.println ("After sbuf1 = new StringBuilder(), ");
    System.out.println ("and after sbuf2 = new StringBuilder(\"abcd\"), ");
    System.out.println ("and after sbuf3 = new StringBuilder(30) ... ");
    System.out.println ("sbuf1.length() = " + sbuf1.length());
    System.out.println ("sbuf2.length() = " + sbuf2.length());
    System.out.println ("sbuf3.length() = " + sbuf3.length());
    System.out.println ("sbuf1.capacity() = " + sbuf1.capacity());
    System.out.println ("sbuf2.capacity() = " + sbuf2.capacity());
    System.out.println ("sbuf3.capacity() = " + sbuf3.capacity());
    System.out.println ("sbuf2.charAt(1) = " + sbuf2.charAt(1));
    sbuf2.setCharAt(2,'Z');
    System.out.println("After sbuf2.setCharAt(2,'Z'): " + sbuf2);
    sbuf2.append("xyz");
    System.out.println("After sbuf2.append(\"xyz\"): " + sbuf2);
    sbuf2.append('?');
    sbuf2.insert(4, "---");
    sbuf2.insert(2, '+');
    System.out.println("After sbuf2.append('?'); " +
                       "sbuf2.insert(4, \"---\");  and " +
                       "sbuf2.insert(2, '+') ... \n sbuf2 = " + sbuf2);
    sbuf2.reverse();
    System.out.println("After sbuf2.reverse(), sbuf2 = " + sbuf2);
    System.out.println("sbuf2 capacity = " + sbuf2.capacity());
    System.out.println("sbuf2 length = " + sbuf2.length());
  }
}
