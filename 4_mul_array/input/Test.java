public class Test {
    static public void main(String [] args) {
        Kyo.sleep(1000);
        Kyo.init();
        int key = Kyo.key();
        Kyo.p("key = %d, rand = %d\n", key, Kyo.rand(100));
        Kyo.exit();
    }
}
