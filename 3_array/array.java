public class array {
    // static public void show(int a[]) {
    static public int [] show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("show a[%d] = %d\n", i, a[i]);
            a[i] = 1777;
        }
        return a;
    }

    static public void main(String [] args) {
        // int a[] = new int[10];
        // int a[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int a[] = {1, 2, 3, 4, 5, 6, 7};

        System.out.printf("length = %d\n", a.length);

        int b[] = show(a);

        for (int i = 0; i < a.length; i++) {
            System.out.printf("b[%d] = %d\n", i, b[i]);
        }

        a[0] = 1678;
        a[1] = 788;
        a[2] = 78;

        /*
         * for (int i : a) {
         *     System.out.printf("%d\n", i);
         * }
         */
    }
}
