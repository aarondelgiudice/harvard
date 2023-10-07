// File Serial.java
// demonstrates how Serialization works with Movie3 objects

import java.io.*;

class Serial
{
    public static void main (String [] args) throws IOException, ClassNotFoundException

    {
        Movie3 vice = new Movie3 ("Vice", 9, 10, 10);
        Movie3 roma = new Movie3 ("Roma", 8, 7, 9);

        ObjectOutputStream os = new ObjectOutputStream (new FileOutputStream ("Movie3.ser"));
        os.writeObject (vice);
        os.writeObject (roma);
        os.close();

        ObjectInputStream is = new ObjectInputStream (
                 new FileInputStream ("Movie3.ser"));

        Movie3 m = (Movie3) is.readObject ();
        Movie3 q = (Movie3) is.readObject ();

        System.out.println (m + "'s rating = " + m.rating());
        System.out.println (q + "'s rating = " + q.rating());
        is.close();
    }
}
