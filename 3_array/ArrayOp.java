import java.util.Scanner;

public class ArrayOp {

    //封装printf函数
    static public void printf(String format, Object ... obj) {
        System.out.printf(format, obj);
    }

    //封装获取随机数函数, 可以指定随机范围
    static public int random(int start, int end) {
        return (int)(Math.random() * (end - start) + start);
    }

    //封装获取随机数函数, 可以指定0到多少的范围
    static public int random(int end) {
        return (int)(Math.random() * end);
    }

    //给传进来的数组赋随机值(可以指定随机值范围)
    static public int[] rand(int [] arr, int start, int end) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random(start, end);
        }
        return arr;
    }

    //返回指定长度的数组并且赋随机值(可以指定随机值范围)
    static public int[] rand(int len, int start, int end) {
        // int arr[] = new int[len];
        return rand(new int[len], start, end);
    }

    //输出数组，第二个参数为true则返回输出字符串，不在函数内输出
    static public String show(int [] arr, boolean ... flags) {
        String out = "";
        for (int i = 0; i < arr.length; i++) {
            out += arr[i];
            if (i == arr.length - 1) {
                out += "\n";
            } else {
                out += " ";
            }
        }
        if (!(flags.length > 0 && flags[0] == true)) {
            printf("%s", out);
        }

        return out;
    }

    // 接受用户输入对数组赋值
    static public int [] input(int [] arr, int start, int end) {
        Scanner sc = new Scanner(System.in);
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

    // 对数组指定范围进行反转
    static public int[] rev(int [] arr, int start, int end) {
        int m, sIndex, eIndex;

        m = (end - start + 1) / 2;

        for (int i = 0; i < m; ++i) {
            sIndex = start + i;
            eIndex = end - i;
            arr[sIndex] ^= arr[eIndex];
            arr[eIndex] ^= arr[sIndex];
            arr[sIndex] ^= arr[eIndex];
        }

        return arr;
    }

    // 对数组进行反转
    static public int[] rev(int [] arr) {
        return rev(arr, 0, arr.length - 1);
    }

    // 求数组最大值
    static public int max(int [] arr) {
        int m, i;

        for (i = 1, m = arr[0]; i < arr.length; ++i) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }

    // 求数组最小值
    static public int min(int [] arr) {
        int m, i;

        for (i = 1, m = arr[0]; i < arr.length; ++i) {
            if (arr[i] < m) {
                m = arr[i];
            }
        }
        return m;
    }

    // 对数组进行循环左移
    static public int [] left(int [] arr) {
        int m = arr.length - 1, index;

        for (int i = 0; i < m; ++i) {
            index = i + 1;
            arr[i] ^= arr[index];
            arr[index] ^= arr[i];
            arr[i] ^= arr[index];
        }

        return arr;
    }

    // 对数组进行循环右移
    static public int [] right(int [] arr) {
        int index;

        for (int i = arr.length - 1; i > 0; --i) {
            index = i - 1;
            arr[i] ^= arr[index];
            arr[index] ^= arr[i];
            arr[i] ^= arr[index];
        }

        return arr;
    }

    // 对数组进行排序
    static public int [] sort(int [] arr) {
        int index, m, i, j;

        //冒泡排序
        /*
         * for (i = 1; i < arr.length; ++i) {
         *     index = arr.length - i;
         *     for (j = 0; j < index; ++j) {
         *         m = j + 1;
         *         if (arr[j] > arr[m]) {
         *             arr[j] ^= arr[m];
         *             arr[m] ^= arr[j];
         *             arr[j] ^= arr[m];
         *         }
         *     }
         * }
         */

        //选择排序
        int tmp;
        m = arr.length - 1;
        for (i = 0; i < m; ++i) {
            index = i;
            tmp = arr[i];
            for (j = i + 1; j < arr.length; ++j) {
                if (arr[j] < tmp) {
                    tmp = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = tmp;
        }

        return arr;
    }

    static public void main(String [] args) {
        int [] arr = rand(10, 0, 100);
        // show(rand(10, 50, 100), true);
        printf("max = %d, min = %d\n", max(arr), min(arr));
        printf("rand: ");
        show(arr);
        printf("input: %s", show(input(arr, 0, 100), true));
        printf("rev: %s", show(rev(arr, 0, 8), true));
        printf("left: %s", show(left(arr), true));
        printf("right: %s", show(right(arr), true));
        printf("sort: %s", show(sort(arr), true));
    }
}
