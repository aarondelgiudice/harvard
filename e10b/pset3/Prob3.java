import java.util.ArrayList;

public class Prob3 {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("Now");
        a.add("Later");
        a.add("Never");

        int aSize = a.size();
        for (int i = 0; i < aSize; i++) {
            a.add(i, "NOT");
        }
        System.out.println(a);
    }
}