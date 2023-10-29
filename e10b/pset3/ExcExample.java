class MyException extends Exception {
}

public class ExcExample {
    public static void main(String[] args) {
        String test = args[0];
        System.out.print("t");
        try {
            doRisky(test);
            System.out.print("r");
            System.out.print("o");
        } catch (MyException e) {
            System.out.print("a");
        } finally {
            System.out.print("w");
            System.out.println("s");
        }
    };

    static void doRisky(String arg) throws MyException {
        System.out.print("h");
        if ("Warren".equals(arg)) {
            throw new MyException();
        }
    }
}