public class ArrayCopy {
    static public void main(String [] args) {
        int a[] = {1, 2, 3, 4, 5};
        // int b[] = a;  //浅拷贝
        int b[] = new int[a.length];

        System.arraycopy(a, 0, b, 0, b.length);

        for (int i = 0; i < b.length; i++) {
            System.out.printf("b[%d] = %d\n", i, b[i]);
            b[i] = (int)(Math.random() * 100);
        }

        int j = 0;
        for (int i : a) {
            System.out.printf("a[%d] = %d\n", j, i);
            j++;
        }

    }
}
