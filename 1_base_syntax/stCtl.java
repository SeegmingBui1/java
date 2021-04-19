public class stCtl {
    static public void main(String [] args) {
        int i, j;

        // 此标签只能放在循环语句的前面
        Q:
        for (i = 1; i < 10; i++) {
            for (j = 1; j <= i; j++)  {
                if (j > 5)
                    break Q; //在退出多次循环时使用
                if (j == 1) {
                    System.out.printf("\033[31m%d x %d = %d\033[0m ", j, i, i * j);
                } else {
                    System.out.printf("%d x %d = %-2d ", j, i, i * j);
                }
            }
            System.out.println();
        }
    }
}
