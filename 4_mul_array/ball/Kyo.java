public class Kyo {
    static public native void init();
    static public native int key();
    static public native void exit();

    static {
        System.loadLibrary("ckey");
    }

    //封装printf函数
    static public void p(String format, Object ... obj) {
        System.out.printf(format, obj);
    }

    //封装获取随机数函数, 可以指定随机范围
    static public int rand(int start, int end) {
        return (int)(Math.random() * (end - start) + start);
    }

    //封装获取随机数函数, 可以指定0到多少的范围
    static public int rand(int end) {
        return (int)(Math.random() * end);
    }

    //延时
    static public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
