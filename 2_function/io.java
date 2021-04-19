import java.util.Scanner;

public class io {
    static public void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("请输入一个整型: ");
        // int num = new java.util.Scanner(System.in).nextInt();
        // int num = new Scanner(System.in).nextInt();
        int num = sc.nextInt();

        System.out.printf("请输入一个浮点整: ");
        float f = sc.nextFloat();

        System.out.printf("请输入一个字符: ");
        char ch = sc.next().charAt(0);

        System.out.printf("num = %d, float = %.2f, char = %c\n", num, f, ch);
    }
}
