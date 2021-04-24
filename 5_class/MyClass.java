
//声明/定义类
class Student {
    //声明/定义成员属性
    private String name = new String();
    byte age = 22;

    String getName() {
        return name;
    }

    public Student(String name, byte age) {
        if (age < 16 || age > 30) {
            System.out.printf("%s: 年龄不符合法规!\n", name);
            return;
        }
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this(name, (byte)22);
    }

    public Student(byte age) {
        this("", age);
    }

    public Student() {

    }

    //对象对比 对比对象的值
    public boolean cmp(Student obj) {
        if (this.name.equals(obj.name) && this.age == obj.age)
            return true;
        return false;
    }

    public boolean setName(String name) {
        if (name == "张四")
            return false;
        this.name = name;
        return true;
    }

    //定义成员方法
    void talk(String pt) {
        System.out.printf("%s -> 学生姓名: %s, 学生年龄: %d 岁!\n",
                    pt, getName(), age);
    }
}

public class MyClass {
    static public void main(String [] args) {
        //实例化对象 创建对象
        // Student s1;     //声明
        // s1 = new Student();  //实例化
        Student s1 = new Student(); //声明实例化
        Student s2 = new Student("张三"); //声明实例化
        Student s3 = new Student((byte)25); //声明实例化
        Student s4 = new Student("王二", (byte)21); //声明实例化

        // s3.init("王二", (byte)117);


        //给对象成员属性赋值
        // s1.name = "张三";
        // if (!s1.setName("张三"))
/*
 *         if (!s1.setName("张四"))
 *             System.out.printf("设置失败!\n");
 *         s1.age = 22;
 *
 *         s2.setName("李四");
 *         s2.age = 16;
 */
        s1.setName("张三");

        // System.out.printf("main 学生姓名: %s\n", s1.getName());
        //访问对象的方法
        s1.talk("s1");
        s2.talk("s2");
        s3.talk("s3");
        s4.talk("s4");


        Student s5 = s1;
        // if (s5 == s1)
        if (s1.cmp(s2))
            System.out.printf("相等!\n");
    }
}
