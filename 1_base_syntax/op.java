public class op {
    static public void main(String [] args) {
        int a = 10, b = 20;
        boolean ba = true, bb = true;

        System.out.printf("a = %d, b = %d\n", a, b);

        System.out.printf("a + b = %d\n", a + b);
        System.out.printf("a - b = %d\n", a - b);
        System.out.printf("a * b = %d\n", a * b);
        System.out.printf("a / b = %d\n", a / b);
        System.out.printf("a %% b = %d\n", a % b);

        System.out.println("a > b = " + (a > b));
        System.out.println("a < b = " + (a < b));
        System.out.println("a >= b = " + (a >= b));
        System.out.println("a <= b = " + (a <= b));
        System.out.println("a == b = " + (a == b));
        System.out.println("a != b = " + (a != b));

        System.out.println("ba && bb = " + (ba && bb));
        System.out.println("ba || bb = " + (ba || bb));
        System.out.println("!ba = " + (!ba));

        // a = a + 10;
        a += 10;

        // a = (a > 10) ? b + 10 : b - 10;
        a = (a > 10) ? (b > 10 ? b + 10 : b + 20) : b - 10;

        /*
         * if (a > 10)
         *     a = b + 10;
         * else
         *     a = b - 10;
         */

        System.out.println("a = " + a);

        System.out.println("last a = " + (a++));
        System.out.println("last last a = " + a);
        // a++ == (a = a + 1)
        // ++a == (a = a + 1)

    }
}
