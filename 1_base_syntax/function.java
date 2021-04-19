import java.util.Scanner;

public class function {
    static public void swap(int a, double d, char c) {
        int b = 678;
        b++;
        System.out.printf("int = %d, double = %f, char = %c\n", a ,d, c);
        a++;
    }

    static public int sub(int a, int b) {
        return a - b;
    }

    static public int add(int a, int b) {
        // return a + b;
        return sub(a, b);
    }

    static public void sum(int a) {
        if (a <= 0)
            return;

        System.out.printf("a = %d\n", a);
        sum(a - 1);
        System.out.printf("a = %d\n", a);
    }

    static public int fb(int n) {
        if (n <= 2)
            return 1;
        return fb(n - 1) + fb(n - 2);
    }

    static public void main(String [] args) {
        int a = 356;
        int b = 7899;

        swap(a, 789, 'T');

        int c = add(a, b);

        c = a + b + add(3, 7);

        System.out.printf("b = %d, a = %d, c = %d, add = %d\n",
                            b, a, c, add(1, 3));

        sum(5);

        System.out.printf("请输入: ");
        int n = new Scanner(System.in).nextInt();
        // System.out.printf("fb(%d) = %d\n", n, fb(n));

        int prev1 = 1, prev2 = 1, s = 1;
        for (int i = 2; i < n; i++) {
            s = prev1 + prev2;
            prev2 = prev1;
            prev1 = s;
        }
        System.out.printf("fb(%d) = %d\n", n, s);
    }
}
