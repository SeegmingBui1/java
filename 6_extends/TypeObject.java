public class TypeObject {
    static public void set(Integer num) {
        System.out.printf("set num = %d\n", num);
        num.valueOf(1999);
        System.out.printf("set num = %d\n", num);
    }

    static public void main(String [] args) {
        Integer i = new Integer(33);
        // int n = i.intValue();
        int n = 8888;

        System.out.printf("int max: %d\n", Integer.MAX_VALUE);
        System.out.printf("int min: %d\n", Integer.MIN_VALUE);
        System.out.println("int hex = 0x" + Integer.toHexString(1999));
        System.out.printf("String to int = %d\n", Integer.parseInt("1999"));

        i = n;

        set(i);

        System.out.printf("i = %d, n = %d\n", i, n);

    }
}
