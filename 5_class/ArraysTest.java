import java.util.Arrays;

public class ArraysTest {
    static public void main(String [] args) {
        int a[] = new int[10];
        int b[] = new int[10];

        // a = b;
        System.arraycopy(a, 0, b, 0, a.length);
        b[3] = 9999;

        System.out.println("== " + (a == b));
        System.out.println("equals " + Arrays.equals(a, b));

        Arrays.fill(a, 0);
        Arrays.fill(a, 0, 5, 100);

        System.out.printf("show a: ");
        for (int val : a) {
            System.out.printf("%d ", val);
        }
        System.out.println();

        System.out.printf("show b: ");
        for (int val : b) {
            System.out.printf("%d ", val);
        }
        System.out.println();

        System.out.printf("array a = %s\n", Arrays.toString(a));
    }
}
