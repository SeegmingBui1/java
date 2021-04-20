public class Mystring {
    static public void main(String [] args) {
        String s = "hello world!";
        String str[] = new String[10];

        for (int i = 0; i < args.length; i++) {
            System.out.printf("args[%d] = %s\n", i, args[i]);
        }

        s = "hello kyo";
        s += " 123";

        System.out.printf("s = %s\n", s);
        System.out.println("s = " + s);

    }
}
