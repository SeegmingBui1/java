public class VaArgs {

    // 方法的可变参 数组实现
    static public void printf(String format, Object ... obj) {
        System.out.printf(format, obj);
    }

    static public void test(int ... nums) {
        printf("test %d: \n", nums.length);
        for (int i = 0; i < nums.length; i++) {
            printf("test args %d = %d\n", i, nums[i]);
        }
        printf("=======================\n");
    }

    static public void main(String [] args) {
        test();
        test(1);
        test(1, 2);
        test(1, 2, 3);
        test(1, 2, 3, 4);
        test(1, 2, 3, 4, 5);
    }
}
