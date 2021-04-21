import java.util.Timer;
import java.util.TimerTask;

public class Ball {
    static int ROW = 15;
    static int COL = 60;
    static char bg[][] = new char[ROW][COL];
    static int x = 3, y = 3, x_inc = 1, y_inc = 1, color = 31;
    static char ch = '@';

    static public void init() {
        int i, j;

        for (i = 0; i < ROW; i++) {
            for (j = 0; j < COL; j++)  {
                if (i == 0 || i == ROW - 1 || j == 0 || j == COL - 1) {
                    bg[i][j] = '#';
                } else {
                    bg[i][j] = ' ';
                }
            }
        }
    }

    static public void show() {
        int i, j;

        Kyo.p("\033[1;1H");     //定位光标到终端左上角
        for (i = 0; i < ROW; i++) {
            for (j = 0; j < COL; j++)  {
                if (bg[i][j] == ch) {
                    System.out.printf("\033[%dm%c\033[0m", color, bg[i][j]);
                } else {
                    System.out.printf("%c", bg[i][j]);
                }
            }
            System.out.printf("\n");
        }
    }

    static public void draw() {
        bg[x][y] = ch;
    }

    static public void move() {
        if (x + x_inc < 0 || x + x_inc > ROW - 1) {
            x_inc = -x_inc;
        }

        if (y + y_inc < 0 || y + y_inc > COL - 1) {
            y_inc = -y_inc;
        }

        x += x_inc;
        y += y_inc;
    }

    static public void main(String [] args) {
        Timer t = new Timer();  //创建定时器对象
        int key;
        //使用获取键盘输入的类 Kyo
        //   前提:
        //      复制input文件夹到本地
        //      进入目录修改makefile, 将CPPFLAGS的路径修改为本地Java的路径
        //      安装gcc: sudo apt install gcc
        //      在当前目录输入命令: make && make install
        //      复制input文件夹的Kyo.java到目标源文件路径
        //

        Kyo.p("\033[?25l");  //关闭光标显示
        Kyo.init();         //初始化终端输入, 依赖linux终端

        //设置定时器任务
        t.schedule(new TimerTask() {
            public void run()  {
                // 定时器设置的时间到了要做的事
                init();
                draw();
                show();
                move();
            }
        }, 100, 100); //定时器设置时间(毫秒), 第一个是首次执行时间，周期执行时间

        while (true) {
            key = Kyo.key();    //获取键盘输入, 返回Int型 -1代表获取失败
                                //165 166 167 168代表方向键
            if (key == 27 || key == 'q') {
                break;
            } else if (key == 32) {
                color = Kyo.rand(8) + 30;
            } else if (key == 165) {
                x_inc = -1;
            } else if (key == 166) {
                x_inc = 1;
            }
        }

        t.cancel();  //关闭定时器, 如果不写会阻塞
        Kyo.exit();   //还原终端输入, 依赖linux终端
        Kyo.p("\033[?25h"); //不愿光标显示
    }
}
