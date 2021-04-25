package kyo;

public class SingleClass {
    int data = 0;
    static SingleClass instance = null;

    private SingleClass() {
        data = 0;
    }

    private SingleClass(int data) {
        this.data = data;
    }

    static public SingleClass getInstance(int data) {
        if (instance == null) {
            instance = new SingleClass(data);
        }
        return instance;
    }

    static public SingleClass getInstance() {
        return getInstance(0);
    }

    public SingleClass set(int data) {
        this.data = data;
        return this;
    }

    public SingleClass show() {
        System.out.printf("SingleClass data = %d\n", data);
        return this;
    }

}

/*
 * public class SingleClassTest {
 *     static public void main(String [] args) {
 *         SingleClass obj = SingleClass.getInstance();
 *         SingleClass new_obj = SingleClass.getInstance();
 * 
 *         obj.set(1999).show();
 *         new_obj.show();
 *     }
 * }
 */
