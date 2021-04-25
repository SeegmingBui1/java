import java.util.Scanner;

class IntArray {
    private int [] arr;
    static final int DEFAULT_MAX = 10;
    static Scanner sc = new Scanner(System.in);

    public IntArray() {
        this.arr = new int[DEFAULT_MAX];
    }

    public IntArray(int len, int ... data) {
        this.arr = new int[len];
        System.arraycopy(data, 0, arr, 0, len);
    }

    public IntArray(int len, int start, int end, String flag) {
        this.arr = new int[len];
        if (flag.equals("rand"))
            this.rand(arr, start, end);
        else
            this.input(arr, start, end);
    }

    int at(int index) {
        return arr[index];
    }

    int [] getArray() {
        return arr;
    }

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

    public IntArray rand(int start, int end) {
        rand(this.arr, start, end);
        return this;
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

    public IntArray show() {
        show(this.arr, false);
        return this;
    }

    public IntArray show(String prompt) {
        printf("%s", prompt);
        return show();
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

    public IntArray input(int start, int end) {
        input(this.arr, start, end);
        return this;
    }


    // 对数组指定范围进行反转
    static public int[] rev(int [] arr, int ... range) {
        int m, start = 0, end = arr.length - 1, sIndex, eIndex;

        if (range.length == 1 && range[0] < arr.length) {
            end = range[0] - 1;
        } else if (range.length == 2
                    && (range[1] < arr.length || range[0] < arr.length)) {
            if (range[0] > range[1]) {
                start = range[1];
                end = range[0] - 1;
            } else {
                start = range[0];
                end = range[1] - 1;
            }
        }

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

    public IntArray rev(int ... range) {
        rev(this.arr, range);
        return this;
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

    public int max() {
        return max(this.arr);
    }

    public int min() {
        return min(this.arr);
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

    public IntArray left() {
        left(this.arr);
        return this;
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

    public IntArray right() {
        right(this.arr);
        return this;
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

     public IntArray sort() {
         sort(this.arr);
         return this;
     }
}

public class IntArrayTest {
    static public void main(String [] args) {
        // System.out.printf("MAX = %d\n", IntArray.DEFAULT_MAX);

        /*
         * // 数组操作的静态版本
         * int [] arr = new int[10];
         * IntArray.rand(arr, 0, 100);
         * IntArray.show(arr);
         * IntArray.printf("max = %d, min = %d\n", IntArray.max(arr), IntArray.min(arr));
         * IntArray.printf("rand: ");
         * IntArray.show(arr);
         * IntArray.printf("input: %s", IntArray.show(IntArray.input(arr, 0, 100), true));
         * IntArray.printf("rev: %s", IntArray.show(IntArray.rev(arr, 0, 8), true));
         * IntArray.printf("left: %s", IntArray.show(IntArray.left(arr), true));
         * IntArray.printf("right: %s", IntArray.show(IntArray.right(arr), true));
         * IntArray.printf("sort: %s", IntArray.show(IntArray.sort(arr), true));
         */

        // 数组操作的类版本
        IntArray arr = new IntArray();
        arr.rand(100, 100).show("rand: ").input(100, 999).show("input: ");
        arr.show().show().show();

    }
}
