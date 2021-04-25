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

class SamllStudent extends Student {
    int x = 36;

    public SamllStudent() {}

    public SamllStudent(String name, int age) {
        super(name, age);
    }

    void talk() {
        set("李四");
        super.talk();
        System.out.printf("smallStudent x = %d, parent x = %d\n", x, super.x);
    }
}

class Stu extends SamllStudent {
    int x = 1999;

    void talk() {
        super.talk();
        System.out.printf("Stu x = %d\n", x);
    }
}

public class SuperTest {
    static public void main(String [] args) {
        // Stu ss = new Stu();
        // Student stu = new Student();
        SamllStudent s = new SamllStudent("hello", 33);

        // SamllStudent p = (SamllStudent)s.set("张三").set(33);
        // ss.talk();

        // p.talk();
    }
}
