import java.util.Scanner;

public class SwitchTest {
    static public void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        // boolean quit = false;

        while (num != 5) {
        // do {
            System.out.printf("1. 打印左上直角三角形!\n");
            System.out.printf("2. 打印左下直角三角形!\n");
            System.out.printf("3. 打印右上直角三角形!\n");
            System.out.printf("4. 打印右下直角三角形!\n");
            System.out.printf("5. 退出!\n");
            System.out.printf("请输入[1 - 5]: ");
            num = sc.nextInt();

            /*
             * if (num == 1) {
             *     System.out.printf("现在正在打印左上直角三角形!\n");
             * } else if (num == 2) {
             *     System.out.printf("现在正在打印左下直角三角形!\n");
             * } else if (num == 3) {
             *     System.out.printf("现在正在打印右上直角三角形!\n");
             * } else if (num == 4) {
             *     System.out.printf("现在正在打印右下直角三角形!\n");
             * } else if (num == 5) {
             *     System.out.printf("退出程序!\n");
             *     break;
             * } else {
             *     System.out.printf("用户乱输入的结果!\n");
             * }
             */
            if (num == 7)
                continue;

            switch (num) {
                case 1:
                    System.out.printf("现在正在打印左上直角三角形!\n");
                    break;
                case 2:
                    System.out.printf("现在正在打印左下直角三角形!\n");
                    break;
                case 3:
                    System.out.printf("现在正在打印右上直角三角形!\n");
                    break;
                case 4:
                    System.out.printf("现在正在打印右下直角三角形!\n");
                    break;
                case 5:
                    System.out.printf("退出程序!\n");
                    // quit = true;
                    break;
                default:
                    System.out.printf("用户乱输入的结果!\n");
                    break;
            }
        }
        // } while (num != 5);
    }
}
