import kyo.SingleClass;

class Student {
    private String name = new String();
    protected int age = 22;     //不能被包外访问

    public Student() {}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

class SamllStudent extends Student {
    int x = 36;

    void smallTalk() {
        set("李四");
        talk();
        System.out.printf("smallStudent x = %d\n", x);
    }
}


public class ExtendsTest {
    static public void main(String [] args) {
/*
 *         Student stu = new Student();
 *         SamllStudent s = new SamllStudent();
 *
 *         // ((SamllStudent)(s.set("张三").set(33))).smallTalk();
 *         SamllStudent p = (SamllStudent)s.set("张三").set(33);
 *
 *         // s.name = "李四";
 *         stu.age = 88;
 *
 *         p.smallTalk();
 */

        testPackage();
    }

    static public void testPackage() {
        SingleClass obj = SingleClass.getInstance();
        SingleClass new_obj = SingleClass.getInstance();

        obj.set(1999).show();
        new_obj.show();
    }
}
