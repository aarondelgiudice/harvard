class StringBuilderExample
{
    public static void main (String [] args)
    {
        String example = replaceCharString ("Now is the time ...", 't', "foobar");
        System.out.println (example);
    }

    static String replaceCharString (String s, char ch, String s2)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ch) result.append (s2);
            else result.append (s.charAt(i));
        }
        return result.toString ();
    }
}