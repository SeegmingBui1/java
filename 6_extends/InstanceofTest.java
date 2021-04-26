
class Student {
    String name = new String();

    public Student() { }
    public Student(String name) {
        this.name = name;
    }

    public void talk() {
        System.out.printf("我的名字: %s\n", name);
    }

    public void show() {
        System.out.printf("学生->我的名字: %s\n", name);
    }
}

class SmallStudent extends Student {
    public SmallStudent() {}
    public SmallStudent(String name) {
        super(name);
    }

    public void show() {
        System.out.printf("小学生->我的名字: %s\n", name);
    }

    public void display() {
        System.out.printf("display 小学生->我的名字: %s\n", name);
    }
}

public class InstanceofTest {

    static public void test(Student obj) {
        System.out.printf("test function: ");
        obj.show();
    }

    static public void test2(Object obj) {
        System.out.printf("test function: ");
        Student p = (Student)obj;
        p.show();
    }

    static public void test1(Object obj) {
        System.out.printf("test function: ");
        if (obj instanceof SmallStudent) {
            SmallStudent p = (SmallStudent)obj;
            p.show();
        } else if (obj instanceof Student) {
            Student p = (Student)obj;
            p.show();
        }
    }

    static public void main(String [] args) {
        // 测试继承 {
        Student s = new Student("张三");
        SmallStudent ss = new SmallStudent("李四");
        // s.show();
        // ss.show();
        //}

        //向上转型 {
        Student p = new SmallStudent("王二");
        // Student p = new Student("王二");

        //父类对象不能调用子类方法
        // p.display();

        //子类重写父类方法则可以使用父类对象调用子类方法(父类对象引用子类实例)
        p.show();
        //}

        // 向下转型 {
        //
        //前提父类对象引用指定子类实例, 强制类型转换回子类对象引用
        SmallStudent sp = (SmallStudent)p;

        sp.display();
        // }
        //
        test(ss);
        test(s);

    }
}
