public class RecTriangle {
    public static void main(String[] args) {
        printTriangle(4);
    }

    public static void printTriangle(int s) {
        if (s < 1)
            return;
        // printTriangle(s - 1); // original behavior
        for (int i = 0; i < s; i++) {
            System.out.print("[]");
        }
        System.out.println();
        printTriangle(s - 1); // new behavior: reverse triangle
    }
}