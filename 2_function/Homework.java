import java.util.Scanner;

public class Homework {

    static Scanner sc;
    static String numString = "0123456789ABCDEF";

    static public int isYear(int year) {
        return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ? 1 : 0;
    }

    //计算两个年之间天数
    static public int countYearDays(int sy, int ey) {
        int days = 0;

        while (sy < ey) {
            days += 365 + isYear(sy++);
        }

        return days;
    }

    // 获取指定月的天数(从1月到指定月的天数)
    static public int countMonthDays(int month, int year) {

        int days = (month - 1) * 30 + month / 2;

        days += (month == 9 || month == 11) ? 1 : 0;

        return (month > 2) ? days - 2 + isYear(year): days;
    }


    // 1. 已知1900年一月一号是星期一，求今年有多少个黑色星期五(13号是星期五即是黑色星期五)
    static public void blackFri() {
        int year = 2017, baseYear = 1900;
        int yearDays, days = 0;

        System.out.printf("请输入要计算的年: ");
        year = sc.nextInt();

        yearDays = countYearDays(baseYear, year) + 13;

        for (int i = 1; i <= 12; i++) {
            days = yearDays + countMonthDays(i, year);
            /*
             * {
             * 1       0
             * 2       1
             * 3       1
             * 4       2
             * 5       2
             * 6       3
             * 7       3
             * 8       4
             * 9       5
             * 10      5
             * 11      6
             * 12      6
             * i / 2
             *
             *}
             */

            /*
             * switch (i) {
             *     case 1:
             *         break;
             *     case 2:
             *     case 4:
             *     case 6:
             *     case 8:
             *     case 9:
             *     case 11:
             *         days += 31;
             *         break;
             *     case 3:
             *         days += 28 + isYear(year);
             *         break;
             *     default:
             *         days += 30;
             *         break;
             * }
             */

            if (days % 7 == 5) {
                System.out.printf("%d 年 %d 月 有黑色星期五!\n", year, i);
            }
        }
    }

    // 8. 输入年月日，判断日期的合法性
    static public boolean checkDate(int year, int month, int day) {
        // 年: 0 - 9999
        //月: 1 - 12
        //日: 1 - 31
        if (year < 0 || year > 9999
                || month < 1 || month > 12
                || day < 1 || day > 31
                || ((month == 4 || month == 6
                        || month == 9 || month == 11) && day > 30)
                || ((month == 2) && day > 28 + isYear(year)))
            return false;

        return true;
    }

    // 2. 张三从2000年1月1号开始过着三天打鱼两天晒网的日子，指定年月日求在打鱼还是晒网
    static public void fish() {
        int year = 2000, month = 1, day = 1, baseYear = 2000;
        int days = 0;

        while (true) {
            System.out.printf("请输入要计算的年: ");
            year = sc.nextInt();
            System.out.printf("请输入要计算的月: ");
            month = sc.nextInt();
            System.out.printf("请输入要计算的日: ");
            day = sc.nextInt();
            if (day == -1) {
                break;
            } else if (year < 2000 || !checkDate(year, month, day)) {
                System.out.printf("你输入的日期格式不合法!\n");
                break;
            }

            // 9. 输入年月日，判断这一天是这一年的第几天
            days = countMonthDays(month, year) + day;
            System.out.printf("%d 年 %d 月 %d 日是这一年的第 %d 天\n",
                                    year, month, day, days);

            days = countYearDays(baseYear, year) + countMonthDays(month, year) + day;
            days %= 5;

            if (days > 0 && days < 4) {
                System.out.printf("张三在打鱼!\n");
            } else {
                System.out.printf("张三在晒网!\n");
            }
        }
    }

    // 4. 求1000以内的完数 (所有因子之和等于本身)
    static public boolean isPerfectNum(int num) {
        int sum = 1;

        for (int i = num / 2; i >= 2; i--) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return (sum == num) ? true : false;
    }

    static public void prefectNum() {
        for (int i = 2; i < 1000; i++) {
            if (isPerfectNum(i)) {
                System.out.printf("%d ", i);
            }
        }
        System.out.println();
    }

    // 5. 求1000以内的水仙花数 (每个位数的立方之和等于本身)
    static public boolean isFlowerNum(int num) {
        int oldNum = num, sum = 0, mod = 0;

        while (num > 0) {
            mod = num % 10;
            sum += mod * mod * mod;
            num /= 10;
        }
        return (sum == oldNum) ? true : false;
    }
    static public void flowerNum() {
        for (int i = 2; i < 1000; i++) {
            if (isFlowerNum(i)) {
                System.out.printf("%d ", i);
            }
        }
        System.out.println();
    }

    // 10. 判断用户输入的数是否是回文数(11,121,12321)
    static public boolean isPalindrome(long num) {
        if (num < 10) {
            return false;
        }
        /*
         * num / 1 % 10
         * num / 10 % 10
         * num / 100 % 10
         * num / 1000 % 10
         * num / 10000 % 10
         * num / 100000 % 10
         */
        long oldNum = num, sum = 0;

        while (num > 0) {
            sum = sum * 10 + num % 10;
            num /= 10;
        }
        return (sum == oldNum) ? true : false;
    }

    static public void palindrome() {
        long num;

        while (true) {
            System.out.printf("请输入一个数字: ");
            num = sc.nextLong();
            if (num == -1) {
                break;
            }

            if (isPalindrome(num)) {
                System.out.printf("%d 是回文数!\n", num);
            } else {
                System.out.printf("\033[31m%d 不是回文数!\033[0m\n", num);
            }
        }
    }

    // 6. 输入一个字符，转换大小写(不能使用if)
    static public void charTo() {
        char ch, ret;

        while (true) {
            System.out.printf("请输入一个字符: ");
            ch = sc.next().charAt(0);
            if (ch == '/') {
                break;
            }

            ret = (char)((ch >= 'a' && ch <= 'z'
                            || ch >= 'A' && ch <= 'Z')
                                ?  ((ch >= 'a') ? ch - 32 : ch + 32)
                                :  ch);

            System.out.printf("%c <==> %c\n", ch, ret);
        }
    }

    // 3. 用一个循环输出等腰梯型(可指定顶和高)
    static public void trapezoid() {
        System.out.printf("请输入梯形的顶: ");
        int t = sc.nextInt();
        System.out.printf("请输入梯形的高: ");
        int h = sc.nextInt();
        int i, j;

        /*
         * 3 5
         * ####***####
         *    *****
         *   *******
         *  *********
         * ***********
         */

        /*
         * for (i = 0; i < h; i++) {
         *     for (j = 0; j < h - i - 1; j++) {
         *         System.out.printf("   ");
         *     }
         *     for (j = 0; j < t + i * 2; j++) {
         *         System.out.printf(" * ");
         *     }
         *     System.out.println();
         * }
         */
        int w = (h - 1) * 2 + t;
        int m = w * h;
        int r, c, s;

        for (i = 0; i < m; i++) {
            c = i % w;
            r = i / w;

            // if (c >= h - r - 1 && c < h - r - 1 + t + r * 2) {
            s = h - r - 1;
            if (c >= s && c < w - s) {
                System.out.printf(" * ");
            } else {
                System.out.printf("   ");
            }

            if (c == w - 1) {
                System.out.println();
            }
        }
    }

    // 7. 4, 5, 6, 7能组合多少个不能被4整除的4位数(位数不能相同, 思考: 一个循环实现)
    static public void genNum() {
        int i, j, k, l, s, sum = 0, count = 0;

        /*
         * for (i = 4; i < 8; ++i) {
         *     for (j = 4; j < 8; ++j) {
         *         for (k = 4; k < 8; ++k) {
         *             for (l = 4; l < 8; ++l) {
         *                 if (i == j || i == k || i == l
         *                            || j == k || j == l || k == l) {
         *                     continue;
         *                 }
         *                 s = i * 1000 + j * 100 + k * 10 + l;
         *                 if (s % 4 != 0) {
         *                     System.out.printf("%d ", s);
         *                     count++;
         *                 }
         *             }
         *         }
         *     }
         * }
         */

        sum = 4 + 5 + 6 + 7;
        for (i = 4; i < 8; ++i) {
            for (j = 4; j < 8; ++j) {
                if (i == j)
                    continue;
                for (k = 4; k < 8; ++k) {
                    if (i == k || j == k) {
                        continue;
                    }
                    l = sum - i - j - k;
                    s = i * 1000 + j * 100 + k * 10 + l;
                    if (s % 4 != 0) {
                        System.out.printf("%d ", s);
                        count++;
                    }
                }
            }
        }
        System.out.printf("\ncount = %d\n", count);

        for (i = 4567, count = 0; i <= 7654; ++i) {
            j = i / 1000 % 10;
            k = i / 100 % 10;
            l = i / 10 % 10;
            s = i % 10;
            if (j >= 4 && j <= 7 && k >= 4 && k <= 7
                    && l >= 4 && l <= 7 && s >= 4 && s <= 7
                    && j != k && j != l && j != s && k != l && k != s
                    && l != s && i % 4 != 0) {
                    System.out.printf("%d ", i);
                    count++;
            }
        }
        System.out.printf("\ncount = %d\n", count);
    }

    // 12. 输出十进制转八进制的数(实现printf("%o")的功能)
    static public void decTo(int num, int bit) {
        if (num == 0)
            return;
        decTo(num / bit, bit);
        System.out.printf("%c", numString.charAt(num % bit));
    }

    static public void decToInput() {
        System.out.printf("请输入数字: ");
        int num = sc.nextInt();
        System.out.printf("请输入转化的进制: ");
        int bit = sc.nextInt();
        decTo(num, bit);
        System.out.println();
    }

    // 13. 猴子吃桃，每天吃前一天的一半加1个桃子，第5天吃完剩一个，求还没吃之前的总数
    static public int eat(int day) {
        if (day == 0)
            return 1;
        return (eat(day - 1) + 1) * 2;
    }

    static public void eatInput() {
        System.out.printf("Total = %d\n", eat(5));
    }

    static public void main(String [] args) {
        sc = new Scanner(System.in);
        // blackFri();
        // fish();
        prefectNum();
        flowerNum();
        // palindrome();
        // charTo();
        // trapezoid();
        // genNum();
        // decToInput();
        eatInput();
    }
}
