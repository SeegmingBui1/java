class Student {
    private String name = new String();
    protected int age = 22;     //不能被包外访问
    int x = 88;

    public Student() {
        System.out.printf("Student init...!\n");
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.printf("Student name age init...!\n");
    }

    public Student set(String name) {
        this.name = name;
        return this;
    }

    public Student set(int age) {
        this.age = age;
        return this;
    }

    void talk() {
        System.out.printf("我的姓名: %s, 我的年龄: %d 岁!\n", name, age);
    }
}

class kyo {
    int a = 33;

    void show() {
        System.out.printf("kyo a = %d\n", a);
        a++;
    }

    protected void finalize() throws Throwable {
        System.out.printf("kyo delete!\n");
    }
}

public class ObjectTest {

    static public void test(Object obj) {
        Student p = (Student)obj;
        p.talk();
    }


    static public void main(String [] args) {
        // Student s = new Student("张三", 22);

        // test(s);

        kyo v = new kyo();

        v.show();

        System.out.println(v.toString());

        v = null;
        System.gc();
    }
}
