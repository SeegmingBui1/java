import java.util.Scanner;

public class Homework {

    static Scanner sc;

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

    static public void main(String [] args) {
        sc = new Scanner(System.in);
        // blackFri();
        fish();
    }
}
