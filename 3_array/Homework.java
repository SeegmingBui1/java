import java.util.Scanner;

public class Homework {
    static Scanner sc = new Scanner(System.in);
    static byte [][] M = {
        {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
        {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    static public int isYear(int year) {
        return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ? 1 : 0;
    }

    // 计算月份的天数
    static public int countMonthDays(int year, int month) {
        int days = 0, y = isYear(year);

        while (--month != 0) {
            days += M[y][month];
        }

        return days;
    }

    //封装printf函数
    static public void printf(String format, Object ... obj) {
        System.out.printf(format, obj);
    }

    // 接受用户输入对数组赋值
    static public int [] input(int [] arr, int start, int end) {
        int num;

        for (int i = 0; i < arr.length; i++) {
            printf("请输入数组第 %d 个元素的值(范围: %d - %d, -1: 停止输入): ",
                            i + 1, start, end);
            num = sc.nextInt();
            if (num == -1) {
                break;
            } else if (num >= start && num <= end) {
                arr[i] = num;
            } else {
                i--;
            }
        }

        return arr;
    }

    //返回指定长度的新数组并且接受用户输入来赋值
    static public int [] input(int len, int start, int end) {
        return input(new int[len], start, end);
    }

    // 从一个数组中找出不重复的第二大数(不考虑负数 不允许排序 不允许使用临时数组)
    static public void secNum() {
        int arr[] = input(10, 0, 9999999);
        int i, j, count, max = -1, sec = -1;  //使用最小数减1作为标识符

        for (i = 0; i < arr.length; ++i) {
            for (j = 0, count = 0; j < arr.length; ++j) {
                // 累加数组元素的重复次数, 当重复一次就退出
                if (arr[i] == arr[j] && ++count > 1) {
                        break;
                }
            }
            //不重复的值进行运算
            if (count == 1) {
                //查找不重复的最大值
                if (arr[i] > max) {
                    sec = max;      //保存不重复的第二大值
                    max = arr[i];   //保存不重复的最大值
                } else if (arr[i] != max && arr[i] > sec) {
                    //当第一个不重复的数为最大值的情况，查找不重复的最大值
                    sec = arr[i];
                }
            }
        }

        printf("max = %d, sec = %d\n", max, sec);
    }

    // M个人围成一圈报数, 报到N的人退出，输出退出顺序
    static public void MN() {
        int m, n, i, count = 0, j = 0;

        printf("请输入多少人: ");
        m = sc.nextInt();

        printf("请输入退出数字: ");
        n = sc.nextInt();

        // sc.next();
        //清除上一次输入的空格
        sc.nextLine();

        String [] p = new String[m];
        for (i = 0; i < m; ++i) {
            printf("请输入第 %d 个人名: ", i + 1);
            p[i] = sc.nextLine();
        }

        while (j < m) {
            for (i = 0; i < m; ++i) {
                if (p[i].length() != 0 && ++count == n) {
                    printf("%s ", p[i]);
                    p[i] = "";
                    count = 0;
                    j++;
                }
            }
        }

        printf("\n");
    }

    // 3 5 7 9能组合多少不能被5整除的4位数，位数不能相同
    static public void genNum() {
        int num, count = 0, sum = 3 + 5 + 7 + 9;
        int a[] = {3, 5, 7, 9};

        for (int i : a) {
            for (int j : a) {
                if (i == j)
                    continue;
                for (int k : a) {
                    if (i == k || j == k)
                        continue;
                    num = i * 1000 + j * 100 + k * 10 + (sum - i - j - k);
                    if (num % 5 != 0) {
                        printf("%d ", num);
                        count++;
                    }
                }
            }
        }
        printf("\ncount = %d\n", count);
    }

    // 对已经存在有序的数组插入一个数据并且保证有序(动态数组)
    static public int [] insertSort(int [] arr, int data) {
        int [] tmpArr = new int[arr.length + 1];
        int index = 0;

        for (int i = arr.length - 1; i >= 0; --i) {
            if (arr[i] < data) {
                index = i + 1;
                break;
            }
        }
        printf("index = %d\n", index);
        System.arraycopy(arr, 0, tmpArr, 0, index);
        tmpArr[index] = data;
        System.arraycopy(arr, index, tmpArr, index + 1, arr.length - index);
        arr = null;

        return tmpArr;
    }

    static public void insertSortTest() {
        int [] a = {1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        printf("请输入需要输入的数据: ");
        int num = sc.nextInt();

        printf("init data: ");
        for (int i : a) {
            printf("%d ", i);
        }
        printf("\n");

        a = insertSort(a, num);

        printf("insert data: ");
        for (int i : a) {
            printf("%d ", i);
        }
        printf("\n");
    }


    static public void main(String [] args) {
        // secNum();
        // MN();
        // genNum();
        insertSortTest();
    }
}
