import java.util.Scanner;

public class Homework {
    static Scanner sc;

    //交互两个变量的值
    static public void swap() {
        int a = 167, b = 286;

        System.out.printf("init a = %d, b = %d\n", a, b);

        int c = a;
        a = b;
        b = c;

        System.out.printf("swap1 a = %d, b = %d\n", a, b);

        a += b;
        b = a - b;
        a -= b;
        //第二种会产生溢出, 不通用

        System.out.printf("swap2 a = %d, b = %d\n", a, b);

        a ^= b;  //a = a ^ b;
        b ^= a;  //b = b ^ a;
        a ^= b;  //a = a ^ b;

        System.out.printf("swap3 a = %d, b = %d\n", a, b);
    }

    // 2. 输入一个数字，将此数字的二进制位第4, 5, 7置1, 将第2, 6位置0, 输出置位后结果
    static public void bitOp() {
        System.out.printf("请输入一个数字: ");
        int num = sc.nextInt();

        /*
         * 1 0100 0100  324
         * 1 1011 0000  0x1b0
         */

        // num = num | (1 << 4 | 1 << 5 | 1 << 7);
        num = num | (3 << 4 | 1 << 7);
        num = num & ~(1 << 2 | 1 << 6);

        System.out.printf("结果: %#x\n", num);
    }

    // 3. 输出1 - 1/2 + 1/3 - 1/4 + 1/5 .... + 1/99 - 1/100的结果(0.69)
    static public void w3() {
        float s = 1;

        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0)
                s -= 1 / (float)i;
            else
                s += 1.0 / i;
        }
        System.out.printf("sum = %.2f\n", s);
    }
    // 4. 把八进制的数转为十进制数(不允许printf转化)
    static public int oct2Dec(int num) {
        int mod, bit = 0, sum = 0, i, sym = 1;

        if (num < 0) {
            sym = -1;
            num *= sym;
        }

        while (num > 0) {
            mod = num % 10;
            if (mod > 7)
                return 0;

            for (i = 0; i < bit; i++) {
                mod *= 8;
            }
            sum += mod;

            bit++;

            num /= 10;
        }

        return sum * sym;
    }

    static public void oct2DecMain() {
        System.out.printf("请输入一个八进制数字: ");
        int num = sc.nextInt();
        int ret = oct2Dec(num);
        if (ret == 0) {
            System.out.printf("%d 不是八进制数!\n", num);
        } else {
            System.out.printf("%d <=> %d\n", num, ret);
        }
    }

    // 5. 求两个数的最大公约数
    static public void w5() {
        System.out.printf("请输入一个数字: ");
        int n1 = sc.nextInt();
        System.out.printf("请再输入一个数字: ");
        int n2 = sc.nextInt();
        int min;

        for (min = n1 > n2 ? n2 : n1; min > 0; min--) {
            if (n1 % min == 0 && n2 % min == 0)
                break;
        }

        System.out.printf("%d 和 %d的最大公约数是 %d\n", n1, n2, min);
    }

    static public void main(String [] args) {
        sc = new Scanner(System.in);
        // swap();
        // bitOp();
        // w3();
        // oct2DecMain();
        w5();
    }
}
