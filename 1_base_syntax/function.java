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

    static public void main(String [] args) {
        int a = 356;
        int b = 7899;

        swap(a, 789, 'T');

        int c = add(a, b);

        c = a + b + add(3, 7);

        System.out.printf("b = %d, a = %d, c = %d, add = %d\n",
                            b, a, c, add(1, 3));
    }
}
